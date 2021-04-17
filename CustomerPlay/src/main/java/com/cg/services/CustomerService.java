package com.cg.services;

import java.util.List;

import com.cg.entities.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer();
	public Customer createCustomer(Customer s);

}
