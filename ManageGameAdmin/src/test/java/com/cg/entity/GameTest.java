package com.cg.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.AdminMSApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdminMSApplication.class)
@WebMvcTest(value = Game.class)
public class GameTest {

	
private Game game = new Game();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetGameId() {
		int mockId = 101;
		game.setGameId(mockId);
		int id = game.getGameId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}
	
	@Test
	void testSetGameId() {
		int mockId = 101;
		game.setGameId(mockId);
		int id = game.getGameId();
		
		assertThat(id).isEqualTo(mockId);
	}
	
	@Test
	void testGetGameName() {
		String mockName = "Ravi";
		game.setGameName(mockName);
		String name = game.getGameName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetGameName() {
		String mockName = "Ravi";
		game.setGameName(mockName);
		String name = game.getGameName();
		
		assertThat(name).isEqualTo(mockName);
	}
	
	@Test
	void testGetGameDescription() {
		String mockName = "RaviKothari";
		game.setGameName(mockName);
		String name = game.getGameName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetGameDescription() {
		String mockName = "RaviKothari";
		game.setGameDescription(mockName);
		String name = game.getGameDescription();
		
		assertThat(name).isEqualTo(mockName);
	}
}
