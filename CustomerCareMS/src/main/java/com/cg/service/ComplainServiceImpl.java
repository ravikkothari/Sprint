package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ComplainDao;
import com.cg.entity.Complain;
import com.cg.exceptions.ResourceNotFoundException;

@Service("comServices")
public class ComplainServiceImpl implements ComplainService{

	public static final Logger logger = LoggerFactory.getLogger(ComplainServiceImpl.class);
	
	@Autowired
	ComplainDao compDao;
	
	@Override
	public List<Complain> getAllComplaints() {
		return compDao.findAll();
	}

	@Override
	public Complain createComplain(Complain s) {
		Complain com = compDao.saveAndFlush(s);
		if(com == null) {
			 new ResourceNotFoundException("Can not create complain profile :: ");
		}
		logger.info("createt complaint");
		return com;
	}
	
	

	@Override
	public Complain viewComplainById(int id) {
		logger.info("view complain by id service");
		Complain a = compDao.findComplainById(id);
			 
			if(a == null) {
				 new ResourceNotFoundException("complain not found for this id :: "+ id);
			}
			return a;
	}

	@Override
	public Complain updateComplain(Complain c, int id) throws ResourceNotFoundException {
		logger.info("update complain service");
		Complain com = compDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("complain not found for this id :: " + id));
		
		c.setComplaintID(com.getComplaintID());
		
		final Complain updatedA= compDao.save(c);
		return updatedA;
	}
	

	@Override
	public boolean deleteComplainById(int id) throws ResourceNotFoundException {
		logger.info("deleteComplainByIdService");
		Complain com = compDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("complain not found for this id :: " + id));
		
		compDao.deleteById(id);
		
		if(com == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean getComplainResolved(int id) throws ResourceNotFoundException{
		
		logger.info("ResolvedComplainByIdService");
		Complain com = compDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("complain not found for this id :: " + id));
		
		compDao.deleteById(id);
		
		if(com == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean genuineIssue(int id) throws ResourceNotFoundException {
		logger.info("genuineIssueComplainByIdService");
		//Complain com = compDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("issue not found for this id :: " + id));
		Complain com1 = new Complain();
		com1.getissue();
		if(com1 == null)
			return false;
		else
			return true;
	}
	
}
