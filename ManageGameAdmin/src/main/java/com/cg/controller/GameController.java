package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.adminDao;
import com.cg.dto.Grequest;
import com.cg.entity.Admin;
import com.cg.entity.Game;
import com.cg.entity.PlayCard;
import com.cg.services.GameServices;
import com.cg.services.PlaycardService;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired 
	GameServices gameServices;
	
	@Autowired
	adminDao admindao;
	
	@Autowired
	PlaycardService playcardServices;
	
	
	@PostMapping("/admin/agames")
	public Admin agames(@RequestBody Grequest request) {
		return admindao.save(request.getAdmin());
	}
	
	@GetMapping("/admin/findAllAdmin")
	public List<Admin> findallgames(){
		return admindao.findAll();
	}
	
	@GetMapping("/admin/findAllGames")
	public List<Game> getAllGame()
	{
		return gameServices.getAllGame();
	}
	
	
	@GetMapping("/findGame/{id}")
	public Game getGameById(@PathVariable Integer id)
	{
		return gameServices.getGameById(id);
	}
	
	
	@GetMapping("/deleteGame/{id}")
	public List<Game> deleteGameById(@PathVariable Integer id)
	{
		return gameServices.deleteGameById(id);
	}
	

	@PostMapping("/insertGame")
	public List<Game> insertGame( Game e)
	{
		
		return gameServices.addGame(e);
	}
	
	
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
		return playcardServices
				
				.getPlaycardById(id);
	}
	
	@GetMapping("/admin/findAllPlaycard")
	public List<PlayCard> getAllPlaycard()
	{
		return playcardServices.getAllPlaycard();
	}
	
}
