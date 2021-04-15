package com.cg.services;

import java.util.List;

import com.cg.entity.Game;



public interface GameServices {
	
	public List<Game> addGame(Game e);
	
	public Game getGameById(Integer gameId);
	
//	public List<Game> updateGame(Game e);
	
	public List<Game> getAllGame();
	
	public List<Game> deleteGameById(Integer  gameId);
}
