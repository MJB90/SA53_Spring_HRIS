package lasp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lasp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByEmail(String email);
	
}