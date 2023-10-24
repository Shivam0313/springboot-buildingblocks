package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name= "User")
public class User {
    @Id
    @GeneratedValue
	private Long id;
    
    @Column(name="USER_NAME", length=50,nullable=false,unique=true)
   @NotEmpty(message = "Username is Mandatory field. Please provide username")
    private String username;
    
  @Size(min=2, message="FirstName should have atleast 2 characters")            
	@Column(name="FIRST_NAME",length=50,nullable=false)
	private String  firstname;
	
	@Column(name="LAST_NAME",length=50,nullable=false)
	private String  lasttname;
	
	@Column(name="EMAIL_ADDRESS",length=50,nullable=false)
	private String   email;
	
	@Column(name="ROLE",length=50,nullable=false)
	private String  role;
	
	@Column(name="SSN",length=50,nullable=false,unique=true)
	private String  ssn;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	public User() {
	
	}

	public User(Long id, String username, String firstname, String lasttname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lasttname = lasttname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lasttname=" + lasttname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}


	
}
