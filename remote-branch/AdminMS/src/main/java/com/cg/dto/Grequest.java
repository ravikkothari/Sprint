package com.cg.dto;

import com.cg.entity.Admin;



public class Grequest {
	private Admin admin;

	public Grequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grequest(Admin admin) {
		super();
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Grequest [admin=" + admin + "]";
	}
	
	
}
