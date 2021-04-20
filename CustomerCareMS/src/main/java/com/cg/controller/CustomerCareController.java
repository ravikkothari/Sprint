package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.CustomerCareDao;
import com.cg.entity.Complain;
import com.cg.entity.CustomerCare;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.CustomerCareService;

@RestController
@RequestMapping("/customercare")
public class CustomerCareController {
	public static final Logger logger = LoggerFactory.getLogger(CustomerCareController.class);

	CustomerCareService ccService;
	
	@GetMapping("/findAll")
	public List<CustomerCare> getAllComp() {
		logger.info("listAllCustomercare Controller");
		return ccService.getAllCustomerCare();
	}
	
	// create customercare
		@PostMapping("/createCustomercare")
		public CustomerCare createComplainController(@Validated @RequestBody CustomerCare s) {
			logger.info("customercare controller createcustomer");
			return ccService.createCustomerCare(s);
		}
		
		// view customercare data by id
		@GetMapping("/viewCustomercareById/{id}")
		public CustomerCare viewCustomercareByIdController(@PathVariable("id") int id) {
			logger.info("customercare controller viewbyid");
			CustomerCare com = ccService.viewCustomercareById(id);
			return com;
		}
		
		// update customercare data by id
		@PutMapping("/updateCustomercare/{id}")
		public CustomerCare updateCustomercareController(@RequestBody CustomerCare s, @PathVariable("id") int id)
				throws ResourceNotFoundException {
			logger.info("updateCustomercare customercare controller");
			return ccService.updateCustomercare(s, id);
		}
		
		// delete by id
		@DeleteMapping("/deleteCustomercareById/{id}")
		public String deleteCustomercareByIdController(@PathVariable("id") int id) throws ResourceNotFoundException {
			logger.info("Customer_careController delete by id");
			if (ccService.deleteCustomercareById(id))
				return "Record deleted Successfully";
			else
				return "Can not delete record";
		}
}
