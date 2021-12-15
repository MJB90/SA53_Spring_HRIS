package sg.edu.iss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import sg.edu.iss.model.Employee;
import sg.edu.iss.service.EmployeeServiceInterface;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface eservice;
	
	// display all employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", eservice.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")     // @ModelAttribute annotation can all the form data be binded to the employee
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		eservice.createEmployee(employee);
		return "redirect:/"; // this redirect means after saving the form, the webpage will jump to the "/" ,also called initial page.
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get employee from service
		Employee employee = eservice.getEmployeeById(id);
		
		// set a employee object to model to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id){
		eservice.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
}
