package com.cashonline.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.User;
import com.cashonline.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.ok().body(this.userService.createUser(user));
	}
	
	@DeleteMapping("/users/{id}")
	public HttpStatus deleteUser(@PathVariable long id) throws ResourceNotFoundException{
		this.userService.deleteUser(id);
		return HttpStatus.OK;
	}
}
