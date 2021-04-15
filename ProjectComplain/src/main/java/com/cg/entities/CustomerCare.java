package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cust")
public class CustomerCare {
	private int customerCareid;
	private int ticketNo;
	
	public CustomerCare() {
		// TODO Auto-generated constructor stub
	}

	public CustomerCare(int customerCareid, int ticketNo) {
		super();
		this.customerCareid = customerCareid;
		this.ticketNo = ticketNo;
	}

	public int getCustomerCareid() {
		return customerCareid;
	}

	public void setCustomerCareid(int customerCareid) {
		this.customerCareid = customerCareid;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "Customer_Care [customerCareid=" + customerCareid + ", ticketNo=" + ticketNo + "]";
	}
	
	

}
