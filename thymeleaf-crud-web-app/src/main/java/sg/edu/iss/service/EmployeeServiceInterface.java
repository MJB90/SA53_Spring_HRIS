package sg.edu.iss.service;

import java.util.List;

import sg.edu.iss.model.Employee;

public interface EmployeeServiceInterface {
	
	public List<Employee> getAllEmployees();
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	
	public void deleteEmployeeById(long id);
	public Employee getEmployeeById(long id);
	
}
