package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Game;

import com.cg.services.GameServices;

@RestController
@RequestMapping("/admin/game")
public class GameController {

	@Autowired 
	GameServices gameServices;
	
	
	@GetMapping("findAllGames")
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
	
	
}
