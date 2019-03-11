package com.example.SpringWebApplication.service;

import com.example.SpringWebApplication.model.StudentDTO;
import com.example.SpringWebApplication.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService implements IDatabaseService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public Optional<StudentDTO> getStudentDetails(int id){
        return studentRepository.findById(id);
    }

    @Override
    public List<StudentDTO> getStudentUsingCriteria(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDTO> criteriaQuery = criteriaBuilder.createQuery(StudentDTO.class);
        Root<StudentDTO> root = criteriaQuery.from(StudentDTO.class);

        Predicate predicate1 = criteriaBuilder.equal(root.get("name"), "Ranga");
        Predicate predicate2 = criteriaBuilder.equal(root.get("name"), "Ravi");

        Predicate whereClause = criteriaBuilder.or(predicate1, predicate2);
        criteriaQuery.where(whereClause);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
