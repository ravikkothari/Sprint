package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comp")
public class Complain implements Serializable{
	
	@Id
	private int customerID;
	private int complaintID;
	
	
	public Complain() {
		
	}


	public Complain(int customerID, int complaintID) {
		super();
		this.customerID = customerID;
		this.complaintID = complaintID;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public int getComplaintID() {
		return complaintID;
	}


	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}


	@Override
	public String toString() {
		return "ComplainEntity [customerID=" + customerID + ", complaintID=" + complaintID + "]";
	}
	
	

	
}
