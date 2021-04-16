package com.cg.services;

import java.util.List;

import com.cg.entities.Customer;




public interface CustomerService {

	Customer createCustomerService(Customer c);

	Customer viewCustomerByIdService(long id);

	List<Customer> listAllCustomerService();

	Customer authCustomer(long id, String pass);

	
	


	

	

	

}
