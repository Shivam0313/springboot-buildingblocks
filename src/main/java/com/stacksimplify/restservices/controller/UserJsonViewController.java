package com.stacksimplify.restservices.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;

@RestController
@Validated
@RequestMapping(value="/jsonview/users")
public class UserJsonViewController {


	@Autowired
	private UserService userService;
	
	//getUserById
		@GetMapping("/external/{userid}")
		public Optional<User> getUserById(@PathVariable @Min(1) Long userid ) {
			try {
				return userService.getUserById(userid);
			} catch (UserNotFoundException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
			}
			
		}
		
		
		//getUserById
				@GetMapping("/internal/{userid}")
				public Optional<User> getUserById2(@PathVariable @Min(1) Long userid ) {
					try {
						return userService.getUserById(userid);
					} catch (UserNotFoundException ex) {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
					}
					
				}
}

