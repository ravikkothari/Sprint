package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.Game;
import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.dao.GameDao;
/**
-File Name          : GameServicesImpl
-Author Name        : Capgemini
-Description        : Game Service Impl Interface 
-Creation Date		: 14/04/2021
*/
@Service
public class GameServicesImpl implements GameServices{

	public static final Logger logger = LoggerFactory.getLogger(GameServicesImpl.class);
	
	@Autowired
	GameDao gamedao;
	
	@Override
	public Game addGame(Game g) {
		logger.info("create game service");
		Game game =gamedao.saveAndFlush(g);
		return game;
	}

	@Override
	public List<Game> getAllGame() {
		logger.info("getting all GameByIdService");
		return gamedao.findAll();
	}

	@Override
	public boolean deleteGameById(Integer gameId) throws ResourceNotFoundException {
		
		logger.info("delete GameByIdService");
		Game game = gamedao.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("game not found for this id :: " + gameId));
		
		gamedao.deleteById(gameId);
		
		if(game == null)
			return false;
		else
			return true;	
		
	}

	@Override
	public Game getGameById(Integer gameId) {
		logger.info("getting GameByIdService");
		Optional<Game> g=gamedao.findById(gameId);
		return g.get();
	}

	@Override
	public Game updateGame(Game g, int gameId) throws ResourceNotFoundException {
		logger.info("update game service");
		Game a = gamedao.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("game not found for this id :: " + gameId));
		
		g.setGameId(a.getGameId());
		
		final Game updatedG= gamedao.saveAndFlush(g);
		return updatedG;
	}
	

}
