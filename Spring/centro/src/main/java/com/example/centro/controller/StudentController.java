package com.example.centro.controller;


import com.example.centro.dto.TeacherDTO;
import com.example.centro.model.Student;
import com.example.centro.model.Teacher;
import com.example.centro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // SELECT * FROM students
    // api/students

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Student> list = studentService.getAll();
        Map<String, Object> response = new HashMap<>();
        if (list.isEmpty()) {
            response.put("code", 2);
        } else {
            response.put("code", 1);
        }
        response.put("message", "lista obtenida correctamente");
        response.put("students", list);
        response.put("size", list.size());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    // api/students/1
    @GetMapping("{id}")
    public ResponseEntity<?> getBy(@PathVariable Long id) {

        Optional<Student> student = studentService.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (student.isPresent()) {
            response.put("code", 1);
            response.put("data", student);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        response.put("code", 2);
        response.put("data", "sin usuario");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("byEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email) {

        Optional<Student> student = studentService.getByEmail(email);
        Map<String, Object> response = new HashMap<>();
        if (student.isPresent()) {
            response.put("code", 1);
            response.put("data", student);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        response.put("code", 2);
        response.put("data", "sin usuario");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Student student) {
        try {
            Student studentAdd = studentService.add(student);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(studentAdd);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(e.getMessage());
        }
        /*
        if(studentAdd==null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentAdd);*/
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestParam String email
            , @RequestBody Student student){
        String message = studentService.updateByEmail(email, student);
        return ResponseEntity.ok(message);
    }

    @PutMapping("update/{locate}")
    public ResponseEntity<?> update(@PathVariable String locate, @RequestParam int phone){
        int size = studentService.updateByLocation(locate, phone);
        return ResponseEntity.ok(size); // 200
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Student student = studentService.deleteById(id);
        return ResponseEntity.ok(student);
    }

}
