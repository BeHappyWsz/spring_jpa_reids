package wsz.spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wsz.spring.jpa.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
