package com.example.hris.services;

import com.example.hris.utility.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(int id);
    void save(EmployeeDTO EmployeeDTO);
    void deleteById(int id);
}
