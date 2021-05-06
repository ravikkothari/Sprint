package com.cg.login.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.cg.login.service.UserDetailsServiceImpl;




@RestController
@RequestMapping("/customer")
public class CustomerController {
	public static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	private RestTemplate restTemplate;
	


	@RequestMapping("/403")
	public String noAuthority() {
		return "403 error You Dont Have Permission to access this page";
	}

	@GetMapping(value = "/getCustomer")
	public ResponseEntity<String> getCustomer() {
		String schemes = restTemplate.getForObject("http://localhost:9106/customer/findAllCUstomer", String.class);
		return ResponseEntity.ok(schemes);
	}

	// view customer data by id
	@GetMapping("/viewCustomerById/{id}")
	public ResponseEntity<String> viewCustomerByIdController() {
		String schemes = restTemplate.getForObject("", String.class);
		return ResponseEntity.ok(schemes);
	}

	@GetMapping(value = "/getgame")
	public ResponseEntity<String> getGame() {
		String schemes = restTemplate.getForObject("http://localhost:9105/admin/game/findAllGames", String.class);
		return ResponseEntity.ok(schemes);
	}
	
	

}
