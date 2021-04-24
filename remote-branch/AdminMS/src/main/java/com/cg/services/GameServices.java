package com.cg.services;

import java.util.List;

import com.cg.entity.Game;
import com.cg.exceptions.ResourceNotFoundException;



public interface GameServices {
	
	public Game addGame(Game e);
	
	public Game getGameById(Integer gameId);
	
	public Game updateGame(Game g, int gameId) throws ResourceNotFoundException;
	
	public List<Game> getAllGame();
	
	public boolean deleteGameById(Integer gameId) throws ResourceNotFoundException;
}
