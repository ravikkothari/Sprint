package com.cg.entity;
import java.io.Serializable;
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
	private int adminId;
	
	
	public Game() {
		super();

	}


	public Game(int gameId, String gameName, String gameDescription, int adminId) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.adminId = adminId;
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


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription
				+ ", adminId=" + adminId + "]";
	}

	
	
	
	

	
}
