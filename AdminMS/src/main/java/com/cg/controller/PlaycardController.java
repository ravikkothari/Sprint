package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.services.PlaycardService;
import com.cg.services.PlaycardServiceImpl;

@RestController
@RequestMapping("/admin/playcard")
public class PlaycardController {

	public static final Logger logger = LoggerFactory.getLogger(PlaycardController.class);
	
	@Autowired
	PlaycardService playcardServices;
	
	//inserting all playcard information
	@PostMapping("/insertPlaycard")
	public List<PlayCard> insertPlaycard( PlayCard p){
		logger.info("playcardController insert by id");
		return playcardServices.addPlaycard(p);
	}
	
	//deleting each playcard information by Id
	@DeleteMapping("/deletePlaycard/{id}")
	public String deletePlaycardById(@PathVariable Integer id) throws ResourceNotFoundException {
		logger.info("playcardController delete by id");
		if(playcardServices.deletePlaycardById(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	//getting each playcard information by Id
	@GetMapping("/findPlaycard/{id}")
	public PlayCard getPlaycardById(@PathVariable Integer id) {
		logger.info("playcardController find by id");
		return playcardServices.getPlaycardById(id);
	}
	
	
	//getting all playcard information
	@GetMapping("findAllPlaycard")
	public List<PlayCard> getAllPlaycard(){
		logger.info("playcardController findAll by id");
		return playcardServices.getAllPlaycard();
	}
	
	//update playcard data by id
			@PutMapping("updatePlaycard/{id}")
			public PlayCard updatePlaycardController(@RequestBody PlayCard p, @PathVariable("id") int id) throws ResourceNotFoundException {
				logger.info("updategame Game controller");
				return playcardServices.updatePlaycard(p, id) ;
			}
}