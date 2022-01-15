package com.example.hris.services;

import com.example.hris.model.Employee;
import com.example.hris.repo.EmployeeRepository;
import com.example.hris.utility.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee e: employees){
            employeeDTOS.add(new EmployeeDTO(e.getId(),e.getFirstName(),e.getLastName(),e.getEmailId()));
        }
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO findById(int id) {
        Employee employee = employeeRepository.findById(Long.valueOf(id)).get();
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(),employee.getFirstName(), employee.getLastName(), employee.getEmailId());
        return employeeDTO;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee;
        if (employeeDTO.getId()==null){
            employee = new Employee();
        }
        else{
            employee = employeeRepository.findById(Long.valueOf(employeeDTO.getId())).get();
        }
        employee.setEmailId(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(Long.valueOf(id));
    }
}
