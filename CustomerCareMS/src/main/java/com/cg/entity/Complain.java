package com.cg.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "complain")
public class Complain implements Serializable{
	
	@Id
	private int complaintID;
	
	//@NotEmpty(message = "Please enter a user id")
	private int userid;
	
	@NotEmpty(message = "Please enter a issue in yes or nothing")
	@Size(min = 0, max = 20, message = "if there is issue,it must be between 1 and 20 characters")
	private String issue;
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}
	
	public Complain(int complaintID, int userid, String issue) {
		super();
		this.complaintID = complaintID;
		this.userid = userid;
		this.issue = issue;
	}
	public int getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getissue() {
		return issue;
		
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "Complain [complaintID=" + complaintID + ", userid=" + userid + ", issue=" + issue + "]";
	}

	
	
	

	
}
