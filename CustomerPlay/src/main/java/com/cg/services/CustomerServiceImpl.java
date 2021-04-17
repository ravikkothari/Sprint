package com.cg.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerDao;
import com.cg.entities.Customer;
import com.cg.exception.ResourceNotFoundException;






@Service
public class CustomerServiceImpl implements CustomerService{
	public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDao customerdao;
	
	@Override
	public List<Customer> getAllCustomer() {
		return customerdao.findAll();
	}
	
	public Customer createCustomer(Customer s) {
		Customer customer = customerdao.save(s);
		if(customer == null) {
			 new ResourceNotFoundException("Can not create admin profile :: ");
		}
		logger.info("create admin service");
		return customer;
	}

	
	
}
