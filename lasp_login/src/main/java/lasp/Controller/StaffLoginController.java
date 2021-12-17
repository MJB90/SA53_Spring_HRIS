package lasp.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lasp.model.User;
import lasp.service.UserService;
import lasp.utility.Login;
import lasp.validators.LoginValidator;



@Controller
@RequestMapping("/staff")
public class StaffLoginController {
	
	@Autowired
	UserService uservice;
	
	@Autowired
	private LoginValidator loginValidator;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}
	
	
	
	@GetMapping("/login")
	public String staffLoginPage(Model model) {
		model.addAttribute("Login", new Login());
		return "staff_login";
	}
	
	
	@RequestMapping("/submit")
	public String staffAthenticate(@ModelAttribute("login")@Valid Login login, BindingResult bindingResult, HttpSession session, Model model) {		
		if (bindingResult.hasErrors()) {
			return "login";
		}
		User currUser = new User();
		currUser.setEmail(login.getEmail());
		currUser.setPassword(login.getPassword());
		currUser = uservice.findUserByEmail(currUser.getEmail());
		List<Role> 
		session.setAttribute("role", currUser.getRole());
		session.setAttribute("id", currUser.getId());
		session.setAttribute("Firstname", currUser.getFirstName());
		session.setAttribute("Lasttname", currUser.getLastName());
		return "redirect:/staff/"; // here the "/" for getting session for each user.
	}
	
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; // back to home page.
	}
	
	
}
