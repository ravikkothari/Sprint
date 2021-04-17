package com.cg.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="managecustomer")
public class Customer {
	

	@Id
	private int customerId;
	
	
	@NotEmpty(message = "Please enter a user name")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String  customerName;
	

	@NotEmpty(message = "Please enter age")
	@Size(min = 10, max = 15, message = "age must be between 10 and 15 characters")
	private int age;
	
	
	@OneToMany(targetEntity = PlayCard.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ap_fk", referencedColumnName = "customerId")
	private List<PlayCard> playcards;
		
		public Customer() {
			super();

		}

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
		
		

		public Customer(int customerId,
				@NotEmpty(message = "Please enter a user name") @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String customerName,
				@NotEmpty(message = "Please enter age") @Size(min = 10, max = 15, message = "age must be between 10 and 15 characters") int age,
				List<PlayCard> playcards) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.age = age;
			this.playcards = playcards;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", age=" + age
					+ ", playcards=" + playcards + "]";
		}

		
		
		

	
	
	
}

