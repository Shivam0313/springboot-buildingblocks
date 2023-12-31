package com.stacksimplify.restservices.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;

@RestController
@RequestMapping(value="/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {

	
	@Autowired
	private UserService userService;
	
	//getUserById - fields with hashset
		@GetMapping("/{userid}")
		public MappingJacksonValue getUserById(@PathVariable @Min(1) Long userid ) {
			try {
				
				Optional<User> optionalUser=userService.getUserById(userid);
				User user= optionalUser.get();
				
				Set<String> fields = new HashSet<String>();
				fields.add("userid");
				fields.add("username");
				fields.add("ssn");
				
				FilterProvider filterProvider = new SimpleFilterProvider()
						.addFilter("userFilter",SimpleBeanPropertyFilter.filterOutAllExcept(fields));
				MappingJacksonValue mapper= new MappingJacksonValue(user);

				mapper.setFilters(filterProvider);
				return mapper;
				
				
			} catch (UserNotFoundException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
			}
			
		}
		
		//getUserById - fields with @Requestparam
				@GetMapping("/params/{id}")
				public MappingJacksonValue getUserById2(@PathVariable @Min(1) Long userid,
						@RequestParam Set<String> fields) {
					try {
						
						Optional<User> optionalUser=userService.getUserById(userid);
						User user= optionalUser.get();
						
						
						
						FilterProvider filterProvider = new SimpleFilterProvider()
								.addFilter("userFilter",SimpleBeanPropertyFilter.filterOutAllExcept(fields));
						MappingJacksonValue mapper= new MappingJacksonValue(user);

						mapper.setFilters(filterProvider);
						return mapper;
						
						
					} catch (UserNotFoundException ex) {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
					}
					
				}
}
