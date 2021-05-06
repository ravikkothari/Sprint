package com.cg.services;
/**
-File Name          : CustomerService
-Author Name        : Capgemini
-Description        : Customer Service Interface 
-Creation Date		: 14/04/2021
*/

import java.util.List;

import com.cg.entity.Complain;
import com.cg.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer c);

	Customer viewCustomerById(int id);

	List<Customer> getAllCustomer();

	String createComplain(Complain c);
}
