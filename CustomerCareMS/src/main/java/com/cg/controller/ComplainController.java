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
import com.cg.entity.Complain;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.ComplainService;
/**
 * -File Name : Complain Controller -Author Name : Capgemini 
 * -Description : Rest Controller for ComplainController Services 
 * -Creation Date : 15/04/2021
 */
@RestController
@RequestMapping("/complain")
public class ComplainController {

	public static final Logger logger = LoggerFactory.getLogger(ComplainController.class);

	@Autowired
	ComplainService complainservice;

	
	/*******************************************************************************
	 * - Method Name : getAllComplain
	 * - Return type : Complain 
	 * - Author : Capgemini
	 * - Creation Date : 15/04/2021 
	 * - Description : Retrieving a Complain from the database.
	 ******************************************************************************/
	@GetMapping("/findAll")
	public List<Complain> getAllComp() {
		logger.info("listAllComplain Controller");
		return complainservice.getAllComplaints();
	}


	/*******************************************************************************
	 * - Method Name : creatComplaint 
	 * - Input Parameters : Complaint s 
	 * - Return type : complaint
	 * game - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : Inserting a Complain into the database.
	 ******************************************************************************/
	@PostMapping("/createComplaint")
	public Complain createComplainController(@Validated @RequestBody Complain s) {
		logger.info("complain controller createcomplain");
		return complainservice.createComplain(s);
	}

	/*******************************************************************************
	 * - Method Name : findComplaintbyId 
	 * - Input Parameters : Integer id 
	 * - Returntype : Complain 
	 * - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : Retrieving a complain by ID from the database.
	 ******************************************************************************/
	@GetMapping("/viewComplainById/{id}")
	public Complain viewComplainByIdController(@PathVariable("id") int id) {
		logger.info("complain controller viewbyid");
		Complain com = complainservice.viewComplainById(id);
		return com;
	}

	/*******************************************************************************
	 - Method Name      : updateComplainbyId
	 - Input Parameters : Complain s, Integer id
	 - Return type      : Complain
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Updating a Complain from the database.
	  ******************************************************************************/
	@PutMapping("/updateComplain/{id}")
	public Complain updateAdminController(@RequestBody Complain s, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		logger.info("updateAdmin admin controller");
		return complainservice.updateComplain(s, id);
	}

	/*******************************************************************************
	 * - Method Name : deleteComplainbyId 
	 * - Input Parameters : Integer id 
	 * - Return type : Complain 
	 * - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : deleting a Complain from the database.
	 ******************************************************************************/
	@DeleteMapping("/deleteComplainById/{id}")
	public String deleteComplainByIdController(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("adminController delete by id");
		if (complainservice.deleteComplainById(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	/*******************************************************************************
	 * - Method Name : ComplainResolvedbyId 
	 * - Input Parameters : Integer id 
	 * - Return type : String
	 * - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : Resolving a Complain from the database.
	 ******************************************************************************/
	@GetMapping("/ComplainResolveById")
	public String getQueryResol(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("query resolving by id");
		if (complainservice.getComplainResolved(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";

	}
	/*******************************************************************************
	 * - Method Name : getissueById 
	 * - Input Parameters : Integer id 
	 * - Return type : String
	 * - Author : Capgemini 
	 * - Creation Date : 15/04/2021 
	 * - Description : issue status from the database.
	 ******************************************************************************/
	@GetMapping("/getissueById")
	public String getIssuestatus(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("issue status by id");
		if (complainservice.genuineIssue(id))
			return "generated issue status Successfully";
		else
			return "Can not generate status";

	}

}
