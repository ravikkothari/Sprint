package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.AdminDao;

import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.services.AdminServices;
import com.cg.exceptions.ResourceNotFoundException;

/**
 * -File Name : Admin Controller 
 * -Author Name : Capgemini 
 * -Description : Rest
 * Controller for Admin Services 
 * -Creation Date : 15/04/2021
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminServices adminservices;

//	@Autowired
//	adminDao admindao;

	@Autowired
	RestTemplate restTemplate;

	/*******************************************************************************
	 * - Method Name : getAllAdmin - Return type : Admin - Author : Capgemini -
	 * Creation Date : 15/04/2021 - Description : Retrieving a Admin from the
	 * database.
	 ******************************************************************************/
	// getting all Admin information
	@GetMapping("findAllAdmin")
	public List<Admin> findallAdmin() {
		logger.info("listAllAdmin AdminController");
		return adminservices.getAllAdmin();
	}

	/*
	 * //authentication of admin
	 * 
	 * @GetMapping("authAdmin/{id}/{pass}") public String
	 * authAdminController(@PathVariable("id") int id, @PathVariable("pass") String
	 * pass){ logger.info("admin authentication controller"); if(
	 * adminservices.authAdmin(id, pass) != null) return "Login Successful"; else
	 * return "Login failed"; }
	 */

	/*******************************************************************************
	 * - Method Name : createAdmin - Input Parameters : Admin s - Return type :
	 * Admin - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * Inserting a Admin into the database.
	 ******************************************************************************/

	@PostMapping("createAdmin")
	public Admin createAdminController(@Validated @RequestBody Admin s) {
		logger.info("admin controller createadmin");
		return adminservices.createAdmin(s);
	}

	/*******************************************************************************
	 * - Method Name : getAdminbyId - Input Parameters : Integer id - Return type :
	 * Admin - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * Retrieving a Customer from the database.
	 ******************************************************************************/

	@GetMapping("viewAdminById/{id}")
	public Admin viewAdminByIdController(@PathVariable("id") int id) {
		logger.info("admin controller viewbyid");
		Admin admin = adminservices.viewAdminById(id);
		return admin;
	}

	/*******************************************************************************
	 * - Method Name : updateAdminbyId - Input Parameters : Admin s, Integer id -
	 * Return type : Admin - Author : Capgemini - Creation Date : 15/04/2021 -
	 * Description : Updating a Customer from the database.
	 ******************************************************************************/

	@PutMapping("updateAdmin/{id}")
	public Admin updateAdminController(@RequestBody Admin s, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		logger.info("updateAdmin admin controller");
		return adminservices.updateAdmin(s, id);
	}

	/*******************************************************************************
	 * - Method Name : deleteAdminbyId - Input Parameters : Integer id - Return type
	 * : Admin - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * deleting a Customer from the database.
	 ******************************************************************************/

	@DeleteMapping("deleteAdminById/{id}")
	public String deleteAdminByIdController(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("adminController delete by id");
		if (adminservices.deleteAdminById(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	/*******************************************************************************
	 * - Method Name : createCustomer - Input Parameters : Customer c - Return type
	 * : Customer - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * Inserting a Customer into the database from Admin.
	 ******************************************************************************/
	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody Customer c) {

		return adminservices.createCustomer(c);

	}

	/*******************************************************************************
	 * - Method Name : getCustomer - Input Parameters : Customer c - Return type :
	 * Customer - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * Retrieving a Customer into the database from Admin.
	 ******************************************************************************/
	@GetMapping(value = "/getcustomer")
	public ResponseEntity<String> getCustomer() {
		String schemes = restTemplate.getForObject("http://localhost:9111/customer/findAllCUstomer", String.class);
		return ResponseEntity.ok(schemes);
	}

}
