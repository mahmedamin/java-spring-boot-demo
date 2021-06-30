package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Muhammad Ahmed",
                        "ahmed@gmail.com",
                        LocalDate.of(1995, Month.JANUARY, 1),
                        33
                )
        );
    }
}
