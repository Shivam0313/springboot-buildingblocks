package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

public class UserDtoV1 {

	
private Long userid;
    
    private String username;
    private String  firstname;
	private String  lasttname;
	private String   email;
	private String  role;
	private String  ssn;
	private List<Order> orders;
	
	
	
	public UserDtoV1() {
	}
	
	
	public UserDtoV1(Long userid, String username, String firstname, String lasttname, String email, String role,
			String ssn, List<Order> orders) {
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.lasttname = lasttname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
	}


	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lasttname;
	}
	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	
}
