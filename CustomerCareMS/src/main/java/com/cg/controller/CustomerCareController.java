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
/**
 * -File Name : ComplainCare Controller 
 * -Author Name : Capgemini 
 * -Description : Rest Controller for CustomerCareController Services 
 * -Creation Date : 15/04/2021
 */
@RestController
@RequestMapping("/customercare")
public class CustomerCareController {
	public static final Logger logger = LoggerFactory.getLogger(CustomerCareController.class);

	CustomerCareService ccService;
	
	/*******************************************************************************
	 * - Method Name : getAllCustomercare
	 * - Return type : Customercare 
	 * - Author : Capgemini
	 * - Creation Date : 15/04/2021 
	 * - Description : Retrieving a Customercare from the database.
	 ******************************************************************************/
	@GetMapping("/findAll")
	public List<CustomerCare> getAllCustomercare() {
		logger.info("listAllCustomercare Controller");
		return ccService.getAllCustomerCare();
	}
	

	/*******************************************************************************
	 * - Method Name : createCustomercare 
	 * - Input Parameters : Customercare s 
	 * - Return type : Customercare
	 * game - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : Inserting a Customercare into the database.
	 ******************************************************************************/
		@PostMapping("/createCustomercare")
		public CustomerCare createComplainController(@Validated @RequestBody CustomerCare s) {
			logger.info("customercare controller createcustomer");
			return ccService.createCustomerCare(s);
		}
		
		/*******************************************************************************
		 * - Method Name : viewCustomercareById 
		 * - Input Parameters : Integer id 
		 * - Returntype : CustomerCare 
		 * - Author : Capgemini 
		 * - Creation Date : 15/04/2021 
		 * - Description : Retrieving a CustomerCare by ID from the database.
		 ******************************************************************************/
		@GetMapping("/viewCustomercareById/{id}")
		public CustomerCare viewCustomercareByIdController(@PathVariable("id") int id) {
			logger.info("customercare controller viewbyid");
			CustomerCare com = ccService.viewCustomercareById(id);
			return com;
		}
		

		/*******************************************************************************
		 - Method Name      : updateCustomercare
		 - Input Parameters : CustomerCare s, Integer id
		 - Return type      : CustomerCare
		 - Author           : Capgemini
		 - Creation Date    : 15/04/2021
		 - Description      : Updating a CustomerCare from the database.
		  ******************************************************************************/
		@PutMapping("/updateCustomercare/{id}")
		public CustomerCare updateCustomercareController(@RequestBody CustomerCare s, @PathVariable("id") int id)
				throws ResourceNotFoundException {
			logger.info("updateCustomercare customercare controller");
			return ccService.updateCustomercare(s, id);
		}
		
		/*******************************************************************************
		 * - Method Name : deleteCustomercareById 
		 * - Input Parameters : Integer id 
		 * - Return type : String
		 * - Author : Capgemini 
		 * - Creation Date : 15/04/2021 
		 * - Description : deleting a CustomerCare from the database.
		 ******************************************************************************/
		@DeleteMapping("/deleteCustomercareById/{id}")
		public String deleteCustomercareByIdController(@PathVariable("id") int id) throws ResourceNotFoundException {
			logger.info("Customer_careController delete by id");
			if (ccService.deleteCustomercareById(id))
				return "Record deleted Successfully";
			else
				return "Can not delete record";
		}
}
