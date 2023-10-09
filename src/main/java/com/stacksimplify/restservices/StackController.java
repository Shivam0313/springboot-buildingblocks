package com.stacksimplify.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {
private String id ="Something";
	@GetMapping("/some")
	public String getSome() {

		return id;
	}
}
