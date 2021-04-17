package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PlaycardDao;
import com.cg.entities.PlayCard;
import com.cg.exception.ResourceNotFoundException;




@Service
public class PlaycardServiceImpl implements PlaycardService{

	public static final Logger logger = LoggerFactory.getLogger(PlaycardServiceImpl.class);
	
	@Autowired
	PlaycardDao playcardDao;
	
	public List<PlayCard> buyPlaycard(PlayCard p) {
		logger.info("buying playcard service");
		playcardDao.saveAndFlush(p);
		return playcardDao.findAll();
	}

	@Override
	public PlayCard getPlaycardById(Integer playcardId) {
		logger.info("getting playcard by Id service");
		Optional<PlayCard> p=playcardDao.findById(playcardId);
		return p.get();
	}

	@Override
	public PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException {
		logger.info("recharge playcard service");
		PlayCard a = playcardDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("playcard not found for this id :: " + id));
		
		p.setPlaycardId(a.getPlaycardId());
		
		final PlayCard rechargeP= playcardDao.saveAndFlush(p);
		return rechargeP;
	}

	@Override
	public List<PlayCard> getAllPlaycard() {
		logger.info("gettingAll playcard service");
		return playcardDao.findAll();
	}

	@Override
	public boolean deletePlaycardById(Integer playcardId)throws ResourceNotFoundException {
		logger.info("deletePlaycardByIdService");
		
		PlayCard p =playcardDao.findById(playcardId).orElseThrow(() -> new ResourceNotFoundException("Playcard not found for this id :: " + playcardId));
		
		playcardDao.deleteById(playcardId);
		
		if(p == null)
			return false;
		else
			return true;
	}
	
	

}
