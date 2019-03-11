package com.example.SpringWebApplication.repositories;

import com.example.SpringWebApplication.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
