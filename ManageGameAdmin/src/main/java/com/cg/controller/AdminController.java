package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.AdminDao;
import com.cg.dto.Grequest;
import com.cg.entity.Admin;
import com.cg.services.AdminServices;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.dto.Grequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminServices adminservices;
	
//	@Autowired
//	adminDao admindao;
	

	@PostMapping("agames")
	public Admin agames(@RequestBody Grequest request) {
		return adminservices.agamess(request);
		
	}
	
	
	//getting all Admin information
	@GetMapping("findAllAdmin")
	public List<Admin> findallAdmin(){
		logger.info("listAllAdmin AdminController");
		return adminservices.getAllAdmin();
	}
	
	
	//authentication of admin
		@GetMapping("authAdmin/{id}/{pass}")
		public String authAdminController(@PathVariable("id") int id, @PathVariable("pass") String pass){
			logger.info("admin authentication controller");
			if( adminservices.authAdmin(id, pass) != null)
				return "Login Successful";
			else
				return "Login failed";
		}
		

		//create admin
		@PostMapping("createAdmin")
		public Admin createAdminController(@Validated @RequestBody Admin s) {
			logger.info("admin controller createadmin");
			return adminservices.createAdmin(s);
		}
		
		//view admin data by id
		@GetMapping("viewAdminById/{id}")
		public Admin viewAdminByIdController(@PathVariable("id") int id){
			logger.info("admin controller viewbyid");
			Admin admin = adminservices.viewAdminById(id);
			return admin;
		}
		
		//update admin data by id
		@PutMapping("updateAdmin/{id}")
		public Admin updateAdminController(@RequestBody Admin s, @PathVariable("id") int id) throws ResourceNotFoundException {
			logger.info("updateAdmin admin controller");
			return adminservices.updateAdmin(s, id) ;
		}
		
		//delete by id
		@DeleteMapping("deleteAdminById/{id}")
		public String deleteAdminByIdController(@PathVariable("id") int id) throws ResourceNotFoundException{
			logger.info("adminController delete by id");
			if(adminservices.deleteAdminById(id))
				return "Record deleted Successfully";
			else
				return "Can not delete record";
		}
		

}
