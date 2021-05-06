package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Complain;
import com.cg.exceptions.ResourceNotFoundException;
/**
-File Name          : ComplainService
-Author Name        : Capgemini
-Description        : Complain Service Interface 
-Creation Date		: 14/04/2021
*/

public interface ComplainService {
	
	public List<Complain> getAllComplaints();	
	public Complain createComplain(Complain s);
	public Complain viewComplainById(int id);
	public Complain updateComplain(Complain c, int id) throws ResourceNotFoundException;
	public boolean deleteComplainById(int id) throws ResourceNotFoundException;
	public boolean getComplainResolved(int id)throws ResourceNotFoundException;
	public boolean genuineIssue(int id)throws ResourceNotFoundException;
	
	

}
