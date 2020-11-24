package com.cashonline.springboot.service;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.User;

public interface UserService {
	
	User createUser(User user);
	
	User getUserById(long id) throws ResourceNotFoundException;
	
	void deleteUser(long id) throws ResourceNotFoundException;

}
