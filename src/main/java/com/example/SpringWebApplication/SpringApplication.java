package com.example.SpringWebApplication;

import com.example.SpringWebApplication.model.StudentDTO;
import com.example.SpringWebApplication.service.IDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringApplication implements CommandLineRunner {
    @Autowired
    IDatabaseService databaseService;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ------------Starting standalone application -------------------");
        List<StudentDTO> students = databaseService.getStudentUsingCriteria();

        int sum = students.stream().reduce(0, (total, student) -> total + student.getId(), Integer :: sum);
        System.out.println(sum);
    }
}
