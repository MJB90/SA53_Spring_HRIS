package sg.edu.iss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.iss.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
