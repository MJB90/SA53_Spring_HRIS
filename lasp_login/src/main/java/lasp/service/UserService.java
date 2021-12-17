package lasp.service;

import lasp.model.User;

public interface UserService {
	
	User findUserByEmail(String email);

}
