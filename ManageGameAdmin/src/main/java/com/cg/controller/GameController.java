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
import com.cg.services.GameServices;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired 
	GameServices gameServices;
	
	@Autowired
	adminDao admindao;
	
	
	@PostMapping("/agames")
	public Admin agames(@RequestBody Grequest request) {
		return admindao.save(request.getAdmin());
	}
	
	@GetMapping("/findAllGames")
	public List<Admin> findallgames(){
		return admindao.findAll();
	}
	
	@GetMapping("/findAll")
	public List<Game> getAllGame()
	{
		return gameServices.getAllGame();
	}
	
	
	@GetMapping("/find/{id}")
	public Game getGameById(@PathVariable Integer id)
	{
		return gameServices.getGameById(id);
	}
	
	
	@GetMapping("/delete/{id}")
	public List<Game> deleteGameById(@PathVariable Integer id)
	{
		return gameServices.deleteGameById(id);
	}
	

	@PostMapping("/insert")
	public List<Game> insertGame( Game e)
	{
		
		return gameServices.addGame(e);
	}
	
	
	
	
}
