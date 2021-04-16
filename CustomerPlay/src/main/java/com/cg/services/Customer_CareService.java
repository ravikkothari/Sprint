package com.cg.services;

import java.util.List;

import com.cg.entities.Customer_Care;


public interface Customer_CareService {
	
	public List<Customer_Care> addCustomer_CareId(Customer_Care c);
	
	public List<Customer_Care> getCustomer_CareResolvingQuery();
	
	public List<Customer_Care> getGenuineIssueCustomer_Care();

}
