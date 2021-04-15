package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manageplaycard")
public class PlayCard {
	@Id
	private int playcardId;
	private String playcardName;
	
	
	public PlayCard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PlayCard(int playcardId, String playcardName) {
		super();
		this.playcardId = playcardId;
		this.playcardName = playcardName;
	}


	public int getPlaycardId() {
		return playcardId;
	}


	public void setPlaycardId(int playcardId) {
		this.playcardId = playcardId;
	}


	public String getPlaycardName() {
		return playcardName;
	}


	public void setPlaycardName(String playcardName) {
		this.playcardName = playcardName;
	}


	@Override
	public String toString() {
		return "PlayCard [playcardId=" + playcardId + ", playcardName=" + playcardName + "]";
	}
	
	
	
}
