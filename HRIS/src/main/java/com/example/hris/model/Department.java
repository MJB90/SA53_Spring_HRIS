package com.example.hris.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
@NoArgsConstructor
public class Department {
    @Id
    private long id;
    private String name;

    @OneToOne
    private Employee manager;

    @OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();
}
