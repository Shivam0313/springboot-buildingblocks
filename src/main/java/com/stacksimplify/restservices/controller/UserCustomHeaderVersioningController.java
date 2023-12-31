package com.stacksimplify.restservices.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;

@RestController
@RequestMapping("/versioning/header/users")
public class UserCustomHeaderVersioningController {
	
@Autowired
	private UserService userService;
@Autowired
private ModelMapper modelMapper;


//Request parameter based Versioning -V1
@GetMapping(value =  "/{id}", headers="API-VERSION=1")
public UserDtoV1 getUserById(@PathVariable @Min(1) Long userid ) throws UserNotFoundException {
		
	Optional<User> userOptional=userService.getUserById(userid);
		
	if(!userOptional.isPresent()){
		throw new UserNotFoundException("user not found");
	}
	User user = userOptional.get();
	
	UserDtoV1 userDtoV1=modelMapper.map(user, UserDtoV1.class);
	return userDtoV1;
		}

// Request Parameter based Versioning -V2
@GetMapping(value =  "/{id}", headers="API-VERSION=2")
public UserDtoV2 getUserById2(@PathVariable @Min(1) Long userid ) throws UserNotFoundException {
		
	Optional<User> userOptional=userService.getUserById(userid);
		
	if(!userOptional.isPresent()){
		throw new UserNotFoundException("user not found");
	}
	User user = userOptional.get();
	
	UserDtoV2 userDtoV2=modelMapper.map(user, UserDtoV2.class);
	return userDtoV2;
		}
}
