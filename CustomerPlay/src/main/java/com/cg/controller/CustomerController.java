package com.cg.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.services.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

		public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);	

		@Autowired
		private CustomerService cs ;
		
		//authentication of customer
		@GetMapping("authCustomer/{id}/{pass}")
		public String authCustomerController(@PathVariable("id") long id, @PathVariable("pass") String pass){
			logger.info("Customer authentication controller");
			if( cs.authCustomer(id, pass) != null)
				return "Login Successful";
			else
				return "Login failed";
		}
		

		//create customer
		@PostMapping("createCustomer")
		public Customer createCustomerController(@Validated @RequestBody Customer s) {
			logger.info("Customer controller createadmin");
			return cs.createCustomerService(s);
		}
		
		//view customer data by id
		@GetMapping("viewAdminById/{id}")
		public Customer viewCustomerByIdController(@PathVariable("id") long id){
			logger.info("Customer controller viewbyid");
			Customer c = cs.viewCustomerByIdService(id);
			return c;
		}
		
		//get all customer
		@GetMapping("listAllCustomer")
		public List<Customer> listAllCustomerController(){
			logger.info("listAllAdmin CustomerController");
			return cs.listAllCustomerService();
		}
		

}

		


