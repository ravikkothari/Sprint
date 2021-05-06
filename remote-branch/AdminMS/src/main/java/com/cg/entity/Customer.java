package com.cg.entity;
/**
-File Name          : Customer
-Author Name        : Capgemini
-Description        : Customer Entity POJO 
-Creation Date		: 12/04/2021
*/
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Customer {
	

	
	private int customerId;
	
	private String customerName;
	

	private int age;
	
	
	private List<PlayCard> playcards;


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<PlayCard> getPlaycards() {
		return playcards;
	}


	public void setPlaycards(List<PlayCard> playcards) {
		this.playcards = playcards;
	}


	


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, String customerName, int age, List<PlayCard> playcards) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
		this.playcards = playcards;
	}


	
}

