package com.example.demo.model.dto;

import com.example.demo.model.Student;

public class StudentDTO {

    private Integer studentID;

    private String firstName;

    private String lastName;

    public StudentDTO(Student student) {
        this.studentID = student.getStudentID();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
    }

    public StudentDTO() {}

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
