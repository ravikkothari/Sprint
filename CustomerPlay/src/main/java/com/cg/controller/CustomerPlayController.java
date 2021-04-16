package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.CustomerDAO;
import com.cg.dto.Prequest;
import com.cg.entities.Cart;
import com.cg.entities.Customer;

import com.cg.services.CustomerPlayService;


@RestController
@RequestMapping("/cart")
public class CustomerPlayController {
	
		@Autowired 
		CustomerPlayService customerplayService;
		
		@Autowired
		CustomerDAO custdao;
		
		
		@PostMapping("/customer/cplaycard")
		public Customer cplaycard(@RequestBody Prequest request) {
			return custdao.save(request.getCustomer());
		}
		
		@PostMapping("/buyplaycard")
		public List<Cart> buyPlaycard( Cart c)
		{
			
			return CustomerPlayService.buyPlaycard(c);
		}
		
		@GetMapping("/rechargePlaycard/{id}")
		public Cart rechargePlaycardById(@PathVariable Integer id)
		{
			return customerplayService.rechargePlaycardById(id);
		}
		
}

