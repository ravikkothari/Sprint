package com.cg.services;

import java.util.List;

import com.cg.entity.Complain;
import com.cg.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer c);

	Customer viewCustomerById(int id);

	List<Customer> getAllCustomer();

	String createComplain(Complain c);
}
