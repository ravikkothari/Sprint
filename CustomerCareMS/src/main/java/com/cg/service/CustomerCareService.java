package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.CustomerCare;
import com.cg.exceptions.ResourceNotFoundException;
/**
-File Name          : CustomerCareService
-Author Name        : Capgemini
-Description        : CustomerCare Service Interface 
-Creation Date		: 14/04/2021
*/

public interface CustomerCareService {
	public List<CustomerCare> getAllCustomerCare();	
	public CustomerCare createCustomerCare(CustomerCare s);
	public CustomerCare viewCustomercareById(int id);
	public CustomerCare updateCustomercare(CustomerCare c, int id) throws ResourceNotFoundException;
	public boolean deleteCustomercareById(int id) throws ResourceNotFoundException;
}
