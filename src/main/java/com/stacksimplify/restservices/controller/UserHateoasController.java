package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.service.UserService;

@RestController
@Validated
@RequestMapping(value="/hateoas/users")
public class UserHateoasController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
//	//getallUsers
//		@GetMapping
//		public List<User> getAllUsers() {
//			return userService.getAllUsers();
//			
//		}
	
	//getUserById
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id ) {
		try {
			Optional<User> userOptional=userService.getUserById(id);
			User user = userOptional.get();
			Long userid=user.getUserid();
			Link selfLink= WebMvcLinkBuilder.linkTo(UserHateoasController.class).slash(userid).withSelfRel();
			user.add(selfLink);
			EntityModel<User> finalresource= EntityModel.of(user);
			return finalresource;
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
		
	}
	
//	@GetMapping("/{id}")
//	public Resource<User> getUserById(@PathVariable("id") @Min(1) Long id ) {
//		try {
//			Optional<User> userOptional=userService.getUserById(id);
//			User user = userOptional.get();
//			Long userid=user.getUserid();
//			Link selfLink= ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
//			user.add(selfLink);
//			Resources<User> finalresource=new Resources<User>(user);
//			return finalresource;
//		} catch (UserNotFoundException ex) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
//		}
//		
//	}
	
	
//	//getallUsers
//		@GetMapping
//		public Reesources<User> getAllUsers() {
//			List<User> allusers= userService.getAllUsers();
//			
//			for(User user : allusers) {
//	// Self Link
//				Long userid = user.getUserid();	
//				Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
//				user.add(selfLink);
//	
//	// Relationship link with getAllOrders
//	
//	Resources<Order> orders= ControllerLinkBuilder.methodOn(OrderHateoasController.class)
//			.getAllorders(userid);
//	Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
//	user.add(ordersLink);
//			}
//	
//	// Self Link for getAllUsers
//	Link  selflinkgetAllUsers = ControllerLinkBuilder.linkTo(this.getClass()).withSelRel();
//			Resources<User> finalResources = new Resources<User>(allusers,selflinkgetAllUsers);
//	return finalResources;
//		}
		
		
		//getallUsers
//				@GetMapping
//				public EntityModel<User> getAllUsers() {
//					List<User> allusers= userService.getAllUsers();
//					
//					for(User user : allusers) {
//			// Self Link
//						Long userid = user.getUserid();	
//						Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
//						user.add(selfLink);
//			
//			// Relationship link with getAllOrders
//			
//			EntityModel<Order> orders= WebMvcLinkBuilder.methodOn(OrderHateoasController.class)
//					.getAllorders(userid);
//			Link ordersLink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders");
//			user.add(ordersLink);
//					}
//			
//			// Self Link for getAllUsers
//			Link  selflinkgetAllUsers = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();
//				EntityModel<User> finalResources = EntityModel.of(selflinkgetAllUsers);
//			return finalResources;
//				}
		
}
