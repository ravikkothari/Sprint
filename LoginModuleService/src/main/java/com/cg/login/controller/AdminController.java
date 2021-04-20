package com.cg.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
		public static final Logger logger = LoggerFactory.getLogger(SampleController.class);
		@Autowired
		private RestTemplate restTemplate;
		
		@GetMapping(value = "/getadmin")
		public ResponseEntity<String> getAdmin() {
			String schemes = restTemplate.getForObject("http://localhost:9105/admin/findAllAdmin", String.class);
			return ResponseEntity.ok(schemes);
		}
		
		
		@RequestMapping("/403")
		public String noAuthority() {
			return "403 error You Dont Have Permission to access this page";
		}
}
