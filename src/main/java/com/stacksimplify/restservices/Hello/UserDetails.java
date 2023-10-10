package com.stacksimplify.restservices.Hello;

public class UserDetails{
	private String firstName;
	private String secondName;
	private String city;
	
	
	public UserDetails(String firstName, String secondName, String city) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.city = city;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", secondName=" + secondName + ", city=" + city + "]";
	}
	
	

}
