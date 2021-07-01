package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody Student student) {
         studentService.addNewStudent(student);
    }

//    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable long id) throws Exception {
//        return studentService.getStudent(id);
//    }
}