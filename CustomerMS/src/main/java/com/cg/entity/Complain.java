package com.cg.entity;
/**
-File Name          : Complain
-Author Name        : Capgemini
-Description        : Complain Entity POJO
-Creation Date		: 16/04/2021
*/

public class Complain {

	private int complaintID;

	private int userid;

	private String issue;

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

	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}
