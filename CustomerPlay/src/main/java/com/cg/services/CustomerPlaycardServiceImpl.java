package com.cg.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.dao.CustomerPlaycardDAO;
import com.cg.entities.CustomerPlaycard;
import com.cg.exception.PlaycardNotFoundException;
import com.surveybuilder.entity.Admin;


@Service
public class CustomerPlaycardServiceImpl implements CustomerPlaycardService {
	
	@Autowired
	CustomerPlaycardDAO playdao;
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerPlaycardServiceImpl.class);
	
	@Override
	public CustomerPlaycard buyPlaycardService(CustomerPlaycard c) {
		CustomerPlaycard p = playdao.save(c);
		if(p == null) {
			 new PlaycardNotFoundException("Can not create admin profile :: ");
		}
		logger.info("create admin service");
		return p;
	}
	
	@Override
	public boolean deletePlaycardByIdService(long id) throws PlaycardNotFoundException {
		logger.info("deletePlaycardByIdService");
		CustomerPlaycard p = playdao.findById(id).orElseThrow(() -> new PlaycardNotFoundException("Playcard not found for this id :: " + id));
		
		playdao.deleteById(id);
		
		if(p == null)
			return false;
		else
			return true;	
	}	
	
	//update customerPlaycard service
		@Override
		public CustomerPlaycard rechargePlaycardService(CustomerPlaycard c, long id) throws PlaycardNotFoundException {
			logger.info("recharge customer service");
			CustomerPlaycard p = playdao.findById(id).orElseThrow(() -> new PlaycardNotFoundException("Recharge can not be done for this id  :: " + id));
			
			
			c.setPlaycardId(p.getPlaycardId());
			
			final CustomerPlaycard updatedplay= playdao.save(c);
			return updatedplay;
		}

}
