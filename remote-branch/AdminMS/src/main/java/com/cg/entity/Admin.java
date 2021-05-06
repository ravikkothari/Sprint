package com.cg.entity;
/**
-File Name          : Admin
-Author Name        : Capgemini
-Description        : Admin Entity POJO 
-Creation Date		: 12/04/2021
*/
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="manageadmin")
public class Admin {
	

	@Id
	private int adminId;
	
	
	@NotEmpty(message = "Please enter a user name")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String adminName;
	
	@NotEmpty(message = "Please enter the password")
	@Size(min = 4, max = 20, message = "Password must be between 4 and 8 characters")
	private String adminPassword;
	
	
	@NotEmpty(message = "Please enter the email")
	@Email(message = "Email should be valid")
	private String adminEmail;

	
	@OneToMany(targetEntity = Game.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ag_fk", referencedColumnName = "adminId")
	private List<Game> games;
	
	
	@OneToMany(targetEntity = PlayCard.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ap_fk", referencedColumnName = "adminId")
	private List<PlayCard> playcards;
		
		public Admin() {
			super();

		}
	
	
		
		public Admin(int adminId,
				@NotEmpty(message = "Please enter a user name") @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String adminName,
				@NotEmpty(message = "Please enter the password") @Size(min = 4, max = 20, message = "Password must be between 4 and 8 characters") String adminPassword,
				@NotEmpty(message = "Please enter the email") @Email(message = "Email should be valid") String adminEmail) {
			super();
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminPassword = adminPassword;
			this.adminEmail = adminEmail;
		}


		public List<Game> getGames() {
			return games;
		}


		public void setGames(List<Game> games) {
			this.games = games;
		}


		

		public List<PlayCard> getPlaycards() {
			return playcards;
		}


		public void setPlaycards(List<PlayCard> playcards) {
			this.playcards = playcards;
		}


		public int getAdminId() {
			return adminId;
		}
		
		
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		
		
		public String getAdminName() {
			return adminName;
		}
		
		
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		
		
		public String getAdminPassword() {
			return adminPassword;
		}
		
		
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		
		
		public String getAdminEmail() {
			return adminEmail;
		}
		
		
		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}


		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
					+ ", adminEmail=" + adminEmail + ", games=" + games + ", playcards=" + playcards + "]";
		}
		
		
	
			
		
			

	
	
	
}

