package com.example.demo.jdbc;

import com.example.demo.model.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDTO getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<StudentDTO>() {
            @Override
            public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentDTO student = new StudentDTO();
                student.setStudentID(rs.getInt("student_id"));
                student.setFirstName(rs.getString("f_name"));
                student.setLastName(rs.getString("l_name"));
                return student;
            }
        });
    }

    public List<StudentDTO> getAllStudents() {
        String sql = "SELECT * FROM t_student";

        return jdbcTemplate.query(sql, new RowMapper<StudentDTO>() {
            @Override
            public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentID(rs.getInt("student_id"));
                studentDTO.setFirstName(rs.getString("f_name"));
                studentDTO.setLastName(rs.getString("l_name"));
                return studentDTO;
            }
        });
    }
}
