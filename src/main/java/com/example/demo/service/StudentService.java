package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        System.out.println(student);
    }

//    public Student getStudent(long id) throws Exception {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new Exception("test"));
//    }

}