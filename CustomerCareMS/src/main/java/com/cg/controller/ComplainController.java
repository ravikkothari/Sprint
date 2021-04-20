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

@RestController
@RequestMapping("/complain")
public class ComplainController {

	public static final Logger logger = LoggerFactory.getLogger(ComplainController.class);

	@Autowired
	ComplainService complainservice;

	@GetMapping("/findAll")
	public List<Complain> getAllComp() {
		logger.info("listAllComplain Controller");
		return complainservice.getAllComplaints();
	}

	// create complaint
	@PostMapping("/createComplaint")
	public Complain createComplainController(@Validated @RequestBody Complain s) {
		logger.info("complain controller createcomplain");
		return complainservice.createComplain(s);
	}

	// view complain data by id
	@GetMapping("/viewComplainById/{id}")
	public Complain viewComplainByIdController(@PathVariable("id") int id) {
		logger.info("complain controller viewbyid");
		Complain com = complainservice.viewComplainById(id);
		return com;
	}

	// update complain data by id
	@PutMapping("/updateComplain/{id}")
	public Complain updateAdminController(@RequestBody Complain s, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		logger.info("updateAdmin admin controller");
		return complainservice.updateComplain(s, id);
	}

	// delete by id
	@DeleteMapping("/deleteComplainById/{id}")
	public String deleteComplainByIdController(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("adminController delete by id");
		if (complainservice.deleteComplainById(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	@GetMapping("/ComplainResolveById")
	public String getQueryResol(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("query resolving by id");
		if (complainservice.getComplainResolved(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";

	}
	
	@GetMapping("/getissueById")
	public String getIssuestatus(@PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("issue status by id");
		if (complainservice.genuineIssue(id))
			return "generated issue status Successfully";
		else
			return "Can not generate status";

	}

}
