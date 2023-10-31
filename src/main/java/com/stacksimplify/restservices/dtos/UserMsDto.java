package com.stacksimplify.restservices.dtos;


public class UserMsDto {

	private Long userid;
	private String username;
	private String emailaddess;
	private String rolename;
	
	public UserMsDto() {
	}


	


	public UserMsDto(Long userid, String username, String emailaddess, String rolename) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailaddess = emailaddess;
		this.rolename = rolename;
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


	public String getEmailaddess() {
		return emailaddess;
	}


	public void setEmailaddess(String emailaddess) {
		this.emailaddess = emailaddess;
	}





	public String getRolename() {
		return rolename;
	}





	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
