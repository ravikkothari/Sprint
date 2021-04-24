package com.cg.servives;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.dao.GameDao;
import com.cg.entity.Game;
import com.cg.services.GameServices;

public class GameServiceTest {

	@Autowired
	private GameServices gameServices;

	@MockBean
	private GameDao gameDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void testCreateGameController() throws Exception {
		Game game = getGame();
	   
	    Mockito.when(gameDao.save(Mockito.any(Game.class))).thenReturn(game);
	    
	    Game result = gameServices.addGame(game);
	    
	    assertThat(game).isEqualTo(result);

	}
	
	@Test
	void testViewGameByIdController() throws Exception {
		
		//Game game = getGame();

		Optional<Game> game = Optional.of(getGame());
		
	    Mockito.when(gameDao.findById(Mockito.anyInt())).thenReturn(game);

	    Game result = gameServices.getGameById(101);
	    
	    assertThat(game).isEqualTo(result);

	}
	
	@Test
	void testUpdateGameController() throws Exception {
		
		Game game = getGame();

		Optional<Game> g = Optional.of(getGame());
	  
	    Mockito.when(gameDao.findById(Mockito.anyInt())).thenReturn(g);
	    Mockito.when(gameDao.save(Mockito.any(Game.class))).thenReturn(game);
	    
	    Game result = gameServices.updateGame(game, 101);
	    
	    assertThat(game).isEqualTo(result);
	}
	
	@Test
	void testDeleteGameByIdController() throws Exception {
		Optional<Game> g = Optional.of(getGame());

	    boolean b = true;
	    
	    Mockito.when(gameDao.findById(Mockito.anyInt())).thenReturn(g);
	    Mockito.doNothing().when(gameDao).deleteById(Mockito.anyInt());
	    
	    boolean result = gameServices.deleteGameById(101);
	    
	    assertThat(b).isEqualTo(result);
	}
	
	@Test
	void testListAllGameController() throws Exception {

		List<Game> g = new ArrayList<Game>();
		
		Game game = getGame();
		g.add(game);
	    
	    Mockito.when(gameDao.findAll()).thenReturn(g);
	   
	    List<Game> result = gameServices.getAllGame();
	    
	    
	    assertThat(g).isEqualTo(result);
	}
	
	private Game getGame() {
		Game g = new Game();
		
		g.setGameId(101);
		g.setGameName("abc");
		g.setGameDescription("abc");
		
		return g;
	}
}
