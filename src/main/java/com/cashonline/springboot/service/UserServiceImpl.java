package com.cashonline.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.User;
import com.cashonline.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) throws ResourceNotFoundException {	
		Optional<User> userOb = this.userRepository.findById(id);
		
		if(userOb.isPresent()) {
			return userOb.get();
		}else {
			throw new ResourceNotFoundException("No existe el Usuario con el id: " + id);
		}
	}

	@Override
	public void deleteUser(long id) throws ResourceNotFoundException {
		Optional<User> userOb = this.userRepository.findById(id);
		
		if(userOb.isPresent()) {
			this.userRepository.delete(userOb.get());
		}else {
			throw new ResourceNotFoundException("No existe el Usuario con el id: " + id);
		}		
	}
	
	

}
