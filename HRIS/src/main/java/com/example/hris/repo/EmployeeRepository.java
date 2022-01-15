package com.example.hris.repo;

import com.example.hris.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("Select e from Employee e join e.projects p where p.projectName = :projectName")
    public List<Employee> findEmployeeByProjects(@Param("projectName") String projectName);

    @Query("Select e from Employee e where concat(e.department.manager.firstName,' ',e.department.manager.lastName) like :managerName and concat(e.firstName,' ',e.lastName) not like :managerName")
    public List<Employee> findEmployeeByManager(@Param("managerName") String managerName);

    @Query("Select e from Employee e join e.projects p where p.value >= 1000 and p.endDate >= :latestDate")
    public List<Employee> findEmployeeByProjectsDate(@Param("latestDate") Date latestDate);

    @Query("Select e from Employee e where e.department.name = :deptName")
    public List<Employee> findEmployeeByDepartment(@Param("deptName") String deptName);
}
