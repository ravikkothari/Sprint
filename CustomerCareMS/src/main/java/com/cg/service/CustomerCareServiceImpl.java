package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerCareDao;

import com.cg.entity.CustomerCare;
import com.cg.exceptions.ResourceNotFoundException;

@Service("cuscareServices")
public class CustomerCareServiceImpl implements CustomerCareService{

public static final Logger logger = LoggerFactory.getLogger(ComplainServiceImpl.class);
	
	@Autowired
	CustomerCareDao custDao;
	
	public List<CustomerCare> getAllCustomerCare() {
		return custDao.findAll();
	}

	
	public CustomerCare createCustomerCare(CustomerCare s) {
		CustomerCare cus = custDao.saveAndFlush(s);
		if(cus == null) {
			 new ResourceNotFoundException("Can not create customercare profile :: ");
		}
		logger.info("createt customercare");
		return cus;
	}

	
	public CustomerCare viewCustomercareById(int id) {
		logger.info("view customercare by id service");
		CustomerCare a = custDao.findCustomercareById(id);
			 
			if(a == null) {
				 new ResourceNotFoundException("complain not found for this id :: "+ id);
			}
			return a;
	}

	
	public CustomerCare updateCustomercare(CustomerCare c, int id) throws ResourceNotFoundException {
		logger.info("update customercare service");
		CustomerCare com = custDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("complain not found for this id :: " + id));
		
		c.setCustomerCareid(com.getCustomerCareid());
		
		final CustomerCare updatedA= custDao.save(c);
		return updatedA;
	}

	
	public boolean deleteCustomercareById(int id) throws ResourceNotFoundException {
		logger.info("deleteCustomercareByIdService");
		CustomerCare com = custDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("complain not found for this id :: " + id));
		
		custDao.deleteById(id);;
		
		if(com == null)
			return false;
		else
			return true;
	}

}
