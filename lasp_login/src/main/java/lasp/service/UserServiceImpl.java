package lasp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lasp.model.User;
import lasp.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository urepo;

	@Override
	public User findUserByEmail(String email) {
		return urepo.findUserByEmail(email);
	}
	

}
