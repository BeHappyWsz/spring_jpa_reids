package wsz.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import wsz.spring.jpa.domain.User;
import wsz.spring.jpa.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
}
