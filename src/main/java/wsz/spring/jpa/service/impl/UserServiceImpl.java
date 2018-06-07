package wsz.spring.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsz.spring.jpa.dao.UserRepository;
import wsz.spring.jpa.domain.User;
import wsz.spring.jpa.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User getUserById(long id) {
		return userRepository.getOne(id);
	}

}
