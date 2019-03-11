package com.example.SpringWebApplication.service;

import com.example.SpringWebApplication.model.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface IDatabaseService {
    Optional<StudentDTO> getStudentDetails(int id);

    List<StudentDTO> getStudentUsingCriteria();
}
