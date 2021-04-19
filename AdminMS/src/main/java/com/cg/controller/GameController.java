package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.Game;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.services.GameServices;

@RestController
@RequestMapping("/admin/game")
public class GameController {

	public static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	GameServices gameServices;

	// getting all game information
	@GetMapping("/findAllGames")
	public List<Game> getAllGame() {
		logger.info("game controller viewAll");
		return gameServices.getAllGame();
	}

	// getting each game information by Id
	@GetMapping("/findGame/{id}")
	public Game getGameById(@PathVariable Integer id) {
		logger.info("game controller viewbyid");
		return gameServices.getGameById(id);
	}

	// deleting each game information by Id
	@DeleteMapping("/deleteGame/{id}")
	public String deleteGameById(@PathVariable Integer id) {
		logger.info("gameController delete by id");
		try {
			if (gameServices.deleteGameById(id))
				return "Record Deleted Successfully";
			else
				return "Not deleted";
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not deleted";
	}

	// inserting game information
	@PostMapping("/insertGame")
	public Game insertGame(@Validated @RequestBody Game e) {
		logger.info("game controller insert");
		return gameServices.addGame(e);
		
	}

	// update game data by id
	@PutMapping("updateAdmin/{id}")
	public Game updateGameController(@RequestBody Game s, @PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("updateAdmin game controller");
		return gameServices.updateGame(s, id);
	}

}
