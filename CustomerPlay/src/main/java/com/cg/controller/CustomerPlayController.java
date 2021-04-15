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
import com.cg.entities.Customer;
import com.cg.entities.Playcard;
import com.cg.services.CustomerPlayService;




@RestController
@RequestMapping("/Playcard")
public class CustomerPlayController {
	
		@Autowired 
		CustomerPlayService customerplayService;
		
		@Autowired
		CustomerDAO custdao;
		
		
		@PostMapping("/cplaycard")
		public Customer cplaycard(@RequestBody Prequest request) {
			return custdao.save(request.getCustomer());
		}
		
		@GetMapping("/findAllPlaycard")
		public List<Customer> buyPlaycard(){
			return custdao.findAll();
		}
		
		
		@GetMapping("/find/{id}")
		public List<Playcard> getAllPlaycardById(@PathVariable Integer id)
		{
			return customerplayService.getPlaycardById(id);
		}
		
		
		@GetMapping("/delete/{id}")
		public List<Playcard> deletePlaycardById(@PathVariable Integer id)
		{
			return customerplayService.deletePlaycardById(id);
		}
		

		@PostMapping("/insert")
		public List<Playcard> rechargePlaycard( Playcard p)
		{
			
			return customerplayService.rechargePlaycard(p);
		}
		
		
		
}

