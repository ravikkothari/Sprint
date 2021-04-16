package com.cg.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
		@Id
		@Column(name="cust_Id")
		private int custId;
		private int gameId;
		private int playcardId;
		
		public int getPlaycardId() {
			return playcardId;
		}

		public void setPlaycardId(int playcardId) {
			this.playcardId = playcardId;
		}

		public Cart() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Cart(int custId, int gameId,int playcardId) {
			super();
			this.custId = custId;
			this.gameId = gameId;
			this.playcardId = playcardId;
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
			return "Cart [custId=" + custId + ", gameId=" + gameId + ", playcardId=" + playcardId + "]";
		}
		
		
		
		
}




