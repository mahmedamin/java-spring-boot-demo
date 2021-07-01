package com.example.demo.config;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ahmed = new Student(
                    "Muhammad Ahmed",
                    "ahmed@gmail.com",
                    LocalDate.of(1995, Month.JANUARY, 1)
            );

            Student john = new Student(
                    "John doe",
                    "john@gmail.com",
                    LocalDate.of(1990, Month.APRIL, 15)
            );

            repository.saveAll(List.of(ahmed, john));
        };
    }
}
