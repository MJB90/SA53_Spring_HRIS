package lasp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import lasp.model.User;

public interface StaffRepository extends JpaRepository<User, Long> {
	
	

}
