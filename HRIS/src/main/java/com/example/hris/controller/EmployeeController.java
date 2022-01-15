package com.example.hris.controller;

import com.example.hris.services.EmployeeService;
import com.example.hris.utility.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private static final String EMPLOYEE = "employee";
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/list")
    public String findAll(Model model){
        List<EmployeeDTO> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute(EMPLOYEE, new EmployeeDTO());
        return "employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("employeeId")
                    int id, Model model) {
        model.addAttribute(EMPLOYEE,
                employeeService.findById(id));
        return "employee-form";
    }
    //Complete
    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute @Valid EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute(EMPLOYEE,employeeDTO);
            return "employee-form";
        }
        employeeService.save(employeeDTO);
        return "redirect:/employees/list";
    }
    //Complete
    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId")
                                         int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }

}
