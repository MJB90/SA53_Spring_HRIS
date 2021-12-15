package sg.edu.iss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.model.Employee;
import sg.edu.iss.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeRepository erepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//List<Employee> employeesList = new ArrayList<Employee>();
		//employeesList = erepo.findAll(); // can i shorter these two lines?
		return erepo.findAll();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		erepo.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		erepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		erepo.deleteById(id);	
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = erepo.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id ::" + id); // (::" + id) that is for mention the id  
		}
		return employee;
	}


}
