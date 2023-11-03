package com.stacksimplify.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {
	
   @Autowired
	private UserRepository userRepository;
   
      
  //getAlluser
   public List<User> getAllUsers() {
	  return  userRepository.findAll();
   }
   
   //createUser
   public User createUser(User user) throws UserExistsException {
	    
	   User existingUser = userRepository.findByUsername(user.getUsername());
	   if(existingUser != null) {
		   throw new UserExistsException("user already exists");
	   }
	   return userRepository.save(user);
   }

   //getUserbyId
   public Optional<User> getUserById(Long userid)throws UserNotFoundException {
	Optional<User> user=userRepository.findById(userid);
	
	if(!user.isPresent()) {
		throw new UserNotFoundException("User Not Found in user Repository");
	}
	return user;
}

   //update USer
   public User updateUserById(Long userid,User user) throws UserNotFoundException {
	   
		Optional<User> optionalUser=userRepository.findById(userid);

		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found in user Repository , provide correct user Id");
		}
		   user.setUserid(userid);
		   return userRepository.save(user);
   }

   //deleteUser
   public void deleteUserById(Long userid) {
	   Optional<User> optionalUser=userRepository.findById(userid);

		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not Found in user Repository , provide correct user Id");
		}

	  				  userRepository.deleteById(userid);
  }

   // get userByName
   public User getuserByUsername(String username) {
	
	return userRepository.findByUsername(username);
}
   
   
}
