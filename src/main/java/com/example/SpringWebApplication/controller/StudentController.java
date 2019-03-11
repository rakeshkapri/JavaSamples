package com.example.SpringWebApplication.controller;

import com.example.SpringWebApplication.model.StudentDTO;
import com.example.SpringWebApplication.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> getStudentDetails(){
        StudentDTO student = databaseService.getStudentDetails(10001).get();
        return new ResponseEntity<>(student,HttpStatus.NO_CONTENT);
    }
}
