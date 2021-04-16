package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.CustomerDAO;
import com.cg.entities.Customer;
import com.cg.exception.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService  {
	

	public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	
	@Autowired
	CustomerDAO custmerdao;
	
	//create customer service
	@Override
	public Customer createCustomerService(Customer c) {
		Customer s = custmerdao.save(c);
		if(s == null) {
			 new CustomerNotFoundException("Can not create customer profile :: ");
		}
		logger.info("create admin service");
		return s;
	}

	//view customer by id service
	@Override
	public Customer viewCustomerByIdService(long id) {
		logger.info("view Customer by id service");
	Customer c = custmerdao.findCustomerById(id);
		
		if(c == null) {
			 new CustomerNotFoundException("customer not found for this id :: "+ id);
		}
		return c;
	}

	//list all Customer service
	@Override
	public List<Customer> listAllCustomerService() {
		logger.info("list all Customer service");
		return custmerdao.findAll();
	}

	//authentication service
	@Override
	public Customer authCustomer(long id, String pass) {
		logger.info("authCustomer service");
		return custmerdao.authCustomer(id, pass);
	}

	

	
}
