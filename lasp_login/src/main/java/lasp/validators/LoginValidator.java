package lasp.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lasp.model.User;
import lasp.service.UserService;
import lasp.utility.Login;

@Configuration
public class LoginValidator implements Validator {
	
	@Autowired
	private UserService uservice;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Login.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login user = (Login) target;
		System.out.println(user);
		String email = user.getEmail();	
		User staff = uservice.findUserByEmail(email);
		if (staff == null) {
			errors.rejectValue("email", "email.error");
		}
		if (staff != null) {
			if (!(staff.getPassword().equals(user.getPassword()))) {
				errors.rejectValue("password", "password.error");
				}
			}
		}
		
		
}

