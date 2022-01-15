package com.example.hris.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Entity
@Data
@Table(name = "user")
public class User extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;
    private String username;
    private String password;
}
