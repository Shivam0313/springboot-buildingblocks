package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;

@RestController
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
		
	}
	
	//getUserById
	@GetMapping("/users/{id}")
	public Optional<User> User(@PathVariable @Min(1) Long id ) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
		
	}
	
	@PostMapping("/createusers")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
		try {
			
			userService.createUser(user);
	//		HttpHeaders headers= new HttpHeaders();
//			headers.setLocation(builder.path("users/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
	public User updateUserById(@PathVariable Long id,@RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());

		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);

	}
	
	//getuserByUserName
	@GetMapping("/users/byusername/{username}")
	public User getUserByusername(@PathVariable String username) throws UserNameNotFoundException{
		User user= userService.getuserByUsername(username);
		
		if(user==null)
			throw new UserNameNotFoundException("Username: "+username +" not found in User Repository");
	return user;
	}
}
