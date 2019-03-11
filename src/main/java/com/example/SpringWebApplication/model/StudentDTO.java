package com.example.SpringWebApplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
