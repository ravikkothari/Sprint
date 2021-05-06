package com.cg.entity;

/**
-File Name          : CustomerCare
-Author Name        : Capgemini
-Description        : CustomerCare Entity POJO 
-Creation Date		: 12/04/2021
*/
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "customercare")
public class CustomerCare {
	@Id
	private int customerCareid;
	
	@NotEmpty(message = "Please enter a customer name")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String customerName;
	
	@OneToMany(targetEntity = Complain.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ap_fk", referencedColumnName = "customerCareid")
	private List<Complain> complaints;

	public CustomerCare() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerCare(int customerCareid, String customerName) {
		super();
		this.customerCareid = customerCareid;
		this.customerName = customerName;
	}

	public int getCustomerCareid() {
		return customerCareid;
	}

	public void setCustomerCareid(int customerCareid) {
		this.customerCareid = customerCareid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Complain> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complain> complaints) {
		this.complaints = complaints;
	}

	@Override
	public String toString() {
		return "Customer_Care [customerCareid=" + customerCareid + ", customerName=" + customerName + ", complaints="
				+ complaints + "]";
	}
	
	
	

}
