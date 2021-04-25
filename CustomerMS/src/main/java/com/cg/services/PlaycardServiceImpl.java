package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PlaycardDAO;
import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class PlaycardServiceImpl implements PlaycardService {

	public static final Logger logger = LoggerFactory.getLogger(PlaycardServiceImpl.class);

	@Autowired
	PlaycardDAO playcardDao;

	// Buy a playcard
	public List<PlayCard> buyPlaycard(PlayCard p) {
		logger.info("buying playcard service");
		playcardDao.saveAndFlush(p);
		return playcardDao.findAll();
	}

	// get playcard by Id
	@Override
	public PlayCard getPlaycardById(Integer playcardId) {
		logger.info("getting playcard by Id service");
		Optional<PlayCard> p = playcardDao.findById(playcardId);
		return p.get();
	}

	// Recharge a playcard
	@Override
	public PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException {
		logger.info("recharge playcard service");
		PlayCard a = playcardDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("playcard not found for this id :: " + id));

		p.setPlaycardId(a.getPlaycardId());

		final PlayCard rechargeP = playcardDao.saveAndFlush(p);
		return rechargeP;
	}

	@Override
	public List<PlayCard> getAllPlaycard() {
		logger.info("gettingAll playcard service");
		return playcardDao.findAll();
	}

}
