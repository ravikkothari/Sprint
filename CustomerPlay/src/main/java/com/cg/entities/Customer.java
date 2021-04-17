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
	
	@NotEmpty(message = "Please enter the password")
	@Size(min = 4, max = 20, message = "Password must be between 4 and 8 characters")
	private String  customerPassword;
	
	
	@NotEmpty(message = "Please enter the email")
	@Email(message = "Email should be valid")
	private String  customerEmail;

	

	
	
	@OneToMany(targetEntity = PlayCard.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ap_fk", referencedColumnName = "customerId")
	private List<PlayCard> playcards;
		
		public Customer() {
			super();

		}
	
	
		
		public Customer(int customerId,
				@NotEmpty(message = "Please enter a user name") @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String customerName,
				@NotEmpty(message = "Please enter the password") @Size(min = 4, max = 20, message = "Password must be between 4 and 8 characters") String customerPassword,
				@NotEmpty(message = "Please enter the email") @Email(message = "Email should be valid") String customerEmail) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPassword = customerPassword;
			this.customerEmail =  customerEmail;
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



		public String getCustomerPassword() {
			return customerPassword;
		}



		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}



		public String getCustomerEmail() {
			return customerEmail;
		}



		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}



		public List<PlayCard> getPlaycards() {
			return playcards;
		}



		public void setPlaycards(List<PlayCard> playcards) {
			this.playcards = playcards;
		}



		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
					+ customerPassword + ", customerEmail=" + customerEmail + ", playcards=" + playcards + "]";
		}


		

		
		
	
			
		
			

	
	
	
}

