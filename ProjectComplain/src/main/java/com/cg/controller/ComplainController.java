package com.cg.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entities.Complain;
import com.cg.service.ComplainService;

@RestController
@RequestMapping("/complain")
public class ComplainController {
	
	private static final Logger logger = LoggerFactory.getLogger(ComplainController.class);
	
	@Autowired
	ComplainService complainservice;
	
	@GetMapping("/findAll")
	public List<Complain> getAllComp(){
		logger.info("get all complain...!!!");
		return complainservice.getAllComplains();
	}
	
	@GetMapping("/Resolved")
	public List<Complain> getAllResol(){
		logger.info("solvedComplain...!!!");
		return complainservice.getComplainResolved();
	}
		
	@PostMapping("/add")
	public  List<Complain> insertComp(Complain c){
		logger.info("add complain...!!!");
			return complainservice.addComplain(c);
}
}
