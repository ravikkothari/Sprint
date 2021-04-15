package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Game;
import com.cg.dao.GameDao;

@Service
public class GameServicesImpl implements GameServices{

	
	@Autowired
	GameDao gamedao;
	
	@Override
	public List<Game> addGame(Game g) {
		
		gamedao.saveAndFlush(g);
		return gamedao.findAll();
	}

//	public List<Game> updateGame(Game g) {

//		gamedao.saveAndFlush(g);
//		return (List<Game>) g;
//	}

	@Override
	public List<Game> getAllGame() {
	
		return gamedao.findAll();
	}

	@Override
	public List<Game> deleteGameById(Integer gameId) {
		
		gamedao.deleteById(gameId);
		return gamedao.findAll();
	}

	@Override
	public Game getGameById(Integer gameId) {
		Optional<Game> g=gamedao.findById(gameId);
		return g.get();
	}
	

}
