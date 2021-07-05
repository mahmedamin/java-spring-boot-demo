package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        var studentOpetional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOpetional.isPresent())
            throw new IllegalStateException("Email has already been taken");

        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        var exists = studentRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException("student with id " + id + " does not exist.");
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(long id, StudentDto dto) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exist."));

        if (!dto.getName().isEmpty() && !Objects.equals(student.getName(), dto.getName()))
            student.setName(dto.getName());

        if (dto.getEmail() != null && !Objects.equals(student.getName(), dto.getEmail())) {
            var studentOptional = studentRepository.findStudentByIdNotAndEmail(id, dto.getEmail());
            if (studentOptional.isPresent())
                throw new IllegalStateException("Email has already been taken");

            student.setEmail(dto.getEmail());
        }
    }

//    public Student getStudent(long id) throws Exception {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new Exception("test"));
//    }

}