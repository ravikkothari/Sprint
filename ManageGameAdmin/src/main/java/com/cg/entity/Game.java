package com.cg.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="managegame")
public class Game {

	@Id
	private int gameId;
	private String gameName;
	private String gameDescription;
	
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Game(int gameId, String gameName, String gameDescription) {
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
