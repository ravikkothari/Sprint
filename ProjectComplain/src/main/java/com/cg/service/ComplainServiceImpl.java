package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.controller.ComplainController;
import com.cg.dao.ComplainDao;
import com.cg.entities.Complain;

@Service("comServices")
public class ComplainServiceImpl implements ComplainService{
	
	private static final Logger logger = LoggerFactory.getLogger(ComplainServiceImpl.class);
	
	@Autowired
	ComplainDao comdao;

	@Override
	public List<Complain> addComplain(Complain c) {
		
		logger.info("add complain");
		comdao.saveAndFlush(c);
		return comdao.findAll();
		
	}

	@Override
	public List<Complain> getComplainResolved() {
		
		logger.info("details of complaint resolved");
		return comdao.findAll();
		
	}

	@Override
	public List<Complain> getAllComplains() {
		logger.info("find all emp");

		return comdao.findAll();
		
	}

}
