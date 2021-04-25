package com.cg.services;

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

	public Customer createCustomer(Customer c) {
		Customer customer = customerdao.save(c);
		if (customer == null) {
			new ResourceNotFoundException("can not create customer profile");
		}
		logger.info("create customer");
		return customer;

	}

	public Customer viewCustomerById(int id) {
		logger.info("view customer by id service");
		Customer customer = customerdao.findCustomerById(id);
		if (customer == null) {
			new ResourceNotFoundException("customer not found for this id:" + id);
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerdao.findAll();
	}

	String url = "http://localhost:9115/complain/createComplaint";

	public String createComplain(Complain c) {
		rest.postForObject(url, c, String.class);
		return "complain raised successfully you will be refunded if any issue from server side";
	}
}
