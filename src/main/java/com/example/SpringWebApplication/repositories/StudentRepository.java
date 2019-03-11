package com.example.SpringWebApplication.repositories;

import com.example.SpringWebApplication.model.StudentDTO;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentDTO, Integer> {
}