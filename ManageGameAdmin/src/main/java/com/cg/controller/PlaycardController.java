package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.PlayCard;
import com.cg.services.PlaycardService;

@RestController
@RequestMapping("/admin/playcard")
public class PlaycardController {

	
	@Autowired
	PlaycardService playcardServices;
	
	
	@PostMapping("/insertPlaycard")
	public List<PlayCard> insertPlaycard( PlayCard p)
	{
		
		return playcardServices.addPlaycard(p);
	}
	
	@GetMapping("/deletePlaycard/{id}")
	public List<PlayCard> deletePlaycardById(@PathVariable Integer id)
	{
		return playcardServices.deletePlaycardById(id);
	}
	
	@GetMapping("/findPlaycard/{id}")
	public PlayCard getPlaycardById(@PathVariable Integer id)
	{
		return playcardServices.getPlaycardById(id);
	}
	
	@GetMapping("findAllPlaycard")
	public List<PlayCard> getAllPlaycard()
	{
		return playcardServices.getAllPlaycard();
	}
}
