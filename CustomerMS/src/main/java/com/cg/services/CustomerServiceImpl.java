package com.cg.services;
/**
-File Name          : CustomerServiceImpl
-Author Name        : Capgemini
-Description        : CustomerService Implementation Class
-Creation Date		: 14/04/2021
*/
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.CustomerDAO;
import com.cg.entity.Complain;
import com.cg.entity.Customer;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerDAO customerdao;

	@Autowired
	RestTemplate rest;
	
	
	/*******************************************************************************
	 - Method Name      : createCustomer
	 - Input Parameters : Customer c
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Inserting a Customer into  the database.
	  ******************************************************************************/ 
	public Customer createCustomer(Customer c) {
		Customer customer = customerdao.save(c);
		if (customer == null) {
			new ResourceNotFoundException("can not create customer profile");
		}
		logger.info("create customer");
		return customer;

	}
	
	
	
	/*******************************************************************************
	 - Method Name      : viewCustomerById
	 - Input Parameters : Integer id
	 - Return type      : Appointment
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a Customer from the database.
	  ******************************************************************************/ 
	public Customer viewCustomerById(int id) {
		logger.info("view customer by id service");
		Customer customer = customerdao.findCustomerById(id);
		if (customer == null) {
			new ResourceNotFoundException("customer not found for this id:" + id);
		}
		return customer;
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : getAllCustomers
	 - Input Parameters : None
	 - Return type      : List<Customer>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a list of Customers from the database.
	  ******************************************************************************/ 
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerdao.findAll();
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : createComplain
	 - Input Parameters : Complain c
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Register a complain
	  ******************************************************************************/ 
	String url = "http://localhost:9115/complain/createComplaint";
	public String createComplain(Complain c) {
		rest.postForObject(url, c, String.class);
		return "complain raised successfully you will be refunded if any issue from server side";
	}
}
