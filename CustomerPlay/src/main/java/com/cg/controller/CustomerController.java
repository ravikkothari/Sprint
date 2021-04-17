package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.services.CustomerService;


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerservices;
	
		@GetMapping("findAllcustomer")
		public List<Customer> findallCustomer(){
			logger.info("listAllCustomer customerController");
			return customerservices.getAllCustomer();
		}
		
		@PostMapping("createCustomer")
		public Customer createCustomerController(@Validated @RequestBody Customer s) {
			logger.info("admin controller createCustomer");
			return customerservices.createCustomer(s);
		}
}
