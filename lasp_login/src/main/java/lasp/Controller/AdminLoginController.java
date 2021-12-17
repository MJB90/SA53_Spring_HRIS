package lasp.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lasp.model.User;
import lasp.service.UserService;
import lasp.utility.Login;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	UserService uservice;
	

	@GetMapping("/login")
	public String adminLoginPage(Model model) {
		model.addAttribute("Login", new Login());
		return "admin_login";
	}
	
	@RequestMapping("/submit")
	public String staffAthenticate(@ModelAttribute("login") Login login, HttpSession session, Model model) {		
		User currUser = new User();
		currUser.setEmail(login.getEmail());
		currUser.setPassword(login.getPassword());
		User existUser = uservice.findUserByEmail(currUser.getEmail());
		if(existUser != null) {
			if(existUser.getPassword() == currUser.getPassword()) {
				return "admin_home";
			}
		}
		return "admin_login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
