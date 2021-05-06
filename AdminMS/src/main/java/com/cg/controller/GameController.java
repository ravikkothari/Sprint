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

/**
 * -File Name : Game Controller 
 * -Author Name : Capgemini 
 * -Description : Rest
 * Controller for Game Services 
 * -Creation Date : 15/04/2021
 */
@RestController
@RequestMapping("/admin/game")
public class GameController {

	public static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	GameServices gameServices;

	/*******************************************************************************
	 * - Method Name : getAllGames - Return type : Game - Author : Capgemini -
	 * Creation Date : 15/04/2021 - Description : Retrieving a Game from the
	 * database.
	 ******************************************************************************/
	@GetMapping("/findAllGames")
	public List<Game> getAllGame() {
		logger.info("game controller viewAll");
		return gameServices.getAllGame();
	}

	/*******************************************************************************
	 * - Method Name : findAdminbyId - Input Parameters : Integer id - Return type :
	 * Admin - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * Retrieving a game by ID from the database.
	 ******************************************************************************/
	@GetMapping("/findGame/{id}")
	public Game getGameById(@PathVariable Integer id) {
		logger.info("game controller viewbyid");
		return gameServices.getGameById(id);
	}

	/*******************************************************************************
	 * - Method Name : deleteGamebyId - Input Parameters : Integer id - Return type
	 * : Game - Author : Capgemini - Creation Date : 15/04/2021 - Description :
	 * deleting a Game from the database.
	 ******************************************************************************/

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

	/*******************************************************************************
	 * - Method Name : createGame - Input Parameters : Game s - Return type : game -
	 * Author : Capgemini - Creation Date : 15/04/2021 - Description : Inserting a
	 * game into the database.
	 ******************************************************************************/

	@PostMapping("/insertGame")
	public Game insertGame(@Validated @RequestBody Game e) {
		logger.info("game controller insert");
		return gameServices.addGame(e);

	}

	/*******************************************************************************
	 * - Method Name : updateGamebyId - Input Parameters : Game s, Integer id -
	 * Return type : Admin - Author : Capgemini - Creation Date : 15/04/2021 -
	 * Description : Updating a Customer from the database.
	 ******************************************************************************/

	@PutMapping("updateAdmin/{id}")
	public Game updateGameController(@RequestBody Game s, @PathVariable("id") int id) throws ResourceNotFoundException {
		logger.info("updateAdmin game controller");
		return gameServices.updateGame(s, id);
	}

}
