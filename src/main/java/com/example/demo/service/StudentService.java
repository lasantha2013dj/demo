package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.jdbc.StudentJdbcDao;
import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    //    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentJdbcDao studentJdbcDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public String getStudentName() {

        Student student = studentDao.getStudentsByStudentID(2);
        String name = student.getFirstName();

        return name;
    }

    public StudentDTO getStudent() {

        Student student = studentDao.getStudentsByStudentID(1);
        StudentDTO studentDTO = new StudentDTO(student);

        return studentDTO;
    }

    public StudentDTO getStudentById(int id) {

        Student student = studentDao.getStudentsByStudentID(id);
        StudentDTO studentDTO = new StudentDTO(student);

        return studentDTO;
    }

    public List<StudentDTO> getStudents() {
        return studentJdbcDao.getAllStudents();
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {

        Student student = null;

        boolean isNew = studentDTO.getStudentID() == null;

        if (!isNew) {
            student = studentDao.getStudentsByStudentID(studentDTO.getStudentID());
        } else {
            student = new Student();
        }
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());

        student = studentDao.saveAndFlush(student);
        return new StudentDTO(student);
    }

}
