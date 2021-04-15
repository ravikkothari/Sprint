package com.cg.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PlayCard")
public class Playcard {
		@Id
		@Column(name="cust_id")
		private int custId;
		private int gameId;
		
		public Playcard(int custId, int gameId) {
			super();
			this.custId = custId;
			this.gameId = gameId;
		}
		
		public int getCustId() {
			return custId;
		}
		public void setCustId(int custId) {
			this.custId = custId;
		}
		public int getGameId() {
			return gameId;
		}
		public void setGameId(int gameId) {
			this.gameId = gameId;
		}
		
		@Override
		public String toString() {
			return "PlayCard [custId=" + custId + ", gameId=" + gameId + "]";
		}
		
		
		
}




