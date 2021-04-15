package com.cg.dto;

import com.cg.entities.Customer;

public class Prequest {

	
		private Customer customer;

		public Prequest() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Prequest(Customer customer) {
			super();
			this.customer = customer;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Prequest [customer=" + customer + "]";
		}
		
		
}


