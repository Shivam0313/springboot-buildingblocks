package com.stacksimplify.restservices.entities;


import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ordersO")
public class Order extends RepresentationModel<Order>{
	//public class Order  extends ResourceSupport{

	@Id
	@GeneratedValue
    @JsonView(Views.Internal.class)

	private Long orderid;
    @JsonView(Views.Internal.class)

	private String orderdescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Order(Long orderid, String orderdescription, User user) {
		super();
		this.orderid = orderid;
		this.orderdescription = orderdescription;
		this.user = user;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getOrderdescription() {
		return orderdescription;
	}

	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderdescription=" + orderdescription + ", user=" + user + "]";
	}
	
	
	
}
