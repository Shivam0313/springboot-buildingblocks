package com.stacksimplify.restservices.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {
	
@Autowired
	private UserService userService;
@Autowired
private ModelMapper modelMapper;


//getUserById
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable @Min(1) Long userid ) throws UserNotFoundException {
		
	Optional<User> userOptional=userService.getUserById(userid);
		
	if(!userOptional.isPresent()){
		throw new UserNotFoundException("user not found");
	}
	User user = userOptional.get();
	
	UserMmDto userMmDto=modelMapper.map(user, UserMmDto.class);
	return userMmDto;
		}

}
