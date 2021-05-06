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

@Entity
@Table(name = "managecustomer")
public class Customer {

	@Id
	private int customerId;

	// Validations for name
	@NotEmpty(message = "Please enter a user name")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String customerName;

	// Validations for age
	@NotNull
	@Min(10)
	@Max(15)
	private int age;

	// foreign key one to many relationship to playcard table
	@OneToMany(targetEntity = PlayCard.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk", referencedColumnName = "customerId")
	private List<PlayCard> playcards;

	// getters and setters
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

	// constructor using fields

	public Customer() {

		super();
	}

	// toString method
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", age=" + age + ", playcards="
				+ playcards + "]";
	}

}
