package com.cg.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entities.Customer_Care;

import com.cg.services.Customer_CareService;


	@RestController
	@RequestMapping("/customer_care")
	public class Customer_CareController {

    private static final Logger logger=LoggerFactory.getLogger(Customer_CareController.class);
    
    @Autowired
    Customer_CareService customer_careservice;
    @GetMapping("/findAll")
    public List<Customer_Care> getAllGenuineIssue(){
    	logger.info("get all genuine issue");
    	return customer_careservice.getGenuineissueCustomer_Care();
    }
    @DeleteMapping("/resolved/{careID}")
    public List<Customer_Care> getAllResol(@PathVariable Integer careID){
    	logger.info("solved all issues");
    	return customer_careservice.getCustomer_CareResolvingQuery();
    }
    
    
	@PostMapping("/add")
	public List<Customer_Care> insertCareId(Customer_Care c){
		logger.info("add customer care id");
		return customer_careservice. addCustomer_CareId(c);
	}
	
	
	
	}


   
