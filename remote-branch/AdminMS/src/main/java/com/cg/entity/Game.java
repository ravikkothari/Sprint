package com.cg.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
-File Name          : Game
-Author Name        : Capgemini
-Description        : Game Entity POJO 
-Creation Date		: 12/04/2021
*/


@Entity
@Table(name="managegame")
public class Game {

	@Id
	private int gameId;
	
	@NotEmpty(message = "Please enter a game name")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String gameName;
	
	@NotEmpty(message = "Please enter a game description")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 40 characters")
	private String gameDescription;
	
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Game(int gameId,
			@NotEmpty(message = "Please enter a game name") @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String gameName,
			@NotEmpty(message = "Please enter a game description") @Size(min = 1, max = 20, message = "Name must be between 1 and 40 characters") String gameDescription) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
	}





	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public String getGameDescription() {
		return gameDescription;
	}


	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}


	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription + "]";
	}
	
	
	
	

	
}
