package com.cg.services;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer c);
	public Customer viewCustomerById(int id);
	public List<Customer> getAllCustomer();
}
