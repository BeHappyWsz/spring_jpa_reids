package wsz.spring.jpa.service;

import java.util.List;

import wsz.spring.jpa.domain.User;

public interface UserService {

	public List<User> getAllUser();

	public User getUserById(long id);
}
