package com.cg.controller;
/**
-File Name          : Customer Controller
-Author Name        : Capgemini
-Description        : Rest Controller for Customer Services
-Creation Date		: 15/04/2021
*/

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.CustomerDAO;
import com.cg.entity.Complain;
import com.cg.entity.Customer;
import com.cg.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerServices;

	@Autowired
	CustomerDAO cdao;

	@Autowired
	RestTemplate restTemplate;
	
	
	/*******************************************************************************
	 - Method Name      : getGame
	 - Input Parameters : None
	 - Return type      : ResponseEntity<String>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving List of Game from Admin
	  ******************************************************************************/
	@GetMapping(value = "/getgame")
	public ResponseEntity<String> getGame() {
		String schemes = restTemplate.getForObject("http://localhost:9105/admin/game/findAllGames", String.class);
		return ResponseEntity.ok(schemes);
	}

	
	/*******************************************************************************
	 - Method Name      : findallCustomer
	 - Input Parameters : None
	 - Return type      : List<Customer>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieve a list of Customers from the database.
	  ******************************************************************************/
	@GetMapping("/findAllCUstomer")
	public List<Customer> findallCustomer() {
		logger.info("listAllCustomer AdminController");
		return customerServices.getAllCustomer();
	}
	
	

	/*******************************************************************************
	 - Method Name      : createCustomer
	 - Input Parameters : Customer c
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Inserting a Customer into the database.
	  ******************************************************************************/
	@PostMapping("/createCustomer")
	public Customer createCustomerController(@Validated @RequestBody Customer c) {
		logger.info("Customer controller create customer");
		return customerServices.createCustomer(c);
	}
	
	

	/*******************************************************************************
	 - Method Name      : viewCustomerbyId
	 - Input Parameters : Integer id
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving a Customer from the database.
	  ******************************************************************************/
	@GetMapping("/viewCustomerById/{id}")
	public Customer viewCustomerByIdController(@RequestBody @PathVariable("id") int id) {
		logger.info("customer controller viewbyId");
		Customer customer = customerServices.viewCustomerById(id);
		return customer;
	}
	
	

	/*******************************************************************************
	 - Method Name      : createComplain
	 - Input Parameters : None
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Creating complain Game from customer
	 ******************************************************************************/
	@PostMapping("/createComplain")
	public String createComplain(@RequestBody Complain c) {

		return customerServices.createComplain(c);
	}

}
