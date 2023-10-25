package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/hateoas/users")
public class OrderHateoasController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	//getallorders for a user
	
	//	@GetMapping("/{userid}/orders")
//	public Resources<Order> getAllorders(@PathVariable Long userid) throws UserNotFoundException{
//
//			Optional<User> userOptional=userRepository.findById(userid);
//		
//		if(!userOptional.isPresent())
//			throw new UserNotFoundException("user not found");
//		
//		List<Order> allorders= userOptional.get().getOrders();
//		Resources<Order> finalResources = new Resources<Order>(allorders);
//		return finalResources;
//	}
		
}
