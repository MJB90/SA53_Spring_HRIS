package com.example.hris;

import com.example.hris.model.Employee;
import com.example.hris.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HrisApplication {
    @Autowired
    EmployeeRepository employeeRepository;
    public static void main(String[] args) {

        SpringApplication.run(HrisApplication.class, args);
    }


	@Bean
    CommandLineRunner runner() {
		return args -> {

            //employees in Narcos
            List<Employee> employeeList = employeeRepository.findEmployeeByProjects("Narcos");
            for(Employee e : employeeList){
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }

            //employees under manager
            System.out.println("Employees under pointy head");
            employeeList = employeeRepository.findEmployeeByManager("pointy head");
            for(Employee e : employeeList){
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }
            //employees under manager
            System.out.println("Projects over 1000");
            LocalDate localDate = LocalDate.now().minusMonths(6);
            Date latestDate = java.sql.Date.valueOf(localDate);

            employeeList = employeeRepository.findEmployeeByProjectsDate(latestDate);
            for(Employee e : employeeList){
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }

            //Employees under department
            System.out.println("Employees under department");
            employeeList = employeeRepository.findEmployeeByDepartment("IT");
            for(Employee e : employeeList){
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }

        };

	}

}
