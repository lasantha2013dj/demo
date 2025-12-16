package com.example.demo.controller;

import com.example.demo.model.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getName", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<String> getStudentName() {

        String name = this.studentService.getStudentName();
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @RequestMapping(value = "/getStudent", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> getStudent() {

        StudentDTO studentDTO = this.studentService.getStudent();
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/getStudentById/{studentID}", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int studentID) {

        StudentDTO studentDTO = this.studentService.getStudentById(studentID);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/getStudents", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> getAllStudents() {

        List<StudentDTO> studentDTOS = studentService.getStudents();
        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveStudent", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentRqDTO) {

        StudentDTO studentDTO = this.studentService.saveStudent(studentRqDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}
