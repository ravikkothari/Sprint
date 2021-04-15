package com.cg.service;

import java.util.List;

import com.cg.entities.Complain;


public interface ComplainService {
	
	public List<Complain> addComplain(Complain c);
	
	public List<Complain> getComplainResolved();
	
	public List<Complain> getAllComplains();

}
