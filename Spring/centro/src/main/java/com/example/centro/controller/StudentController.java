package com.example.centro.controller;


import com.example.centro.model.Student;
import com.example.centro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Student> list = studentService.getAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

}
