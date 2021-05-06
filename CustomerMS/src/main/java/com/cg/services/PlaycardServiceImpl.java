package com.cg.services;
/**
-File Name          : PlaycardServiceImpl
-Author Name        : Capgemini
-Description        : PlaycardService Implementation Class
-Creation Date		: 14/04/2021
*/

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


	/*******************************************************************************
	 - Method Name      : buyPlaycard
	 - Input Parameters : None
	 - Return type      : List<Playcard>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a list of playcard from the database.
	  ******************************************************************************/ 
	public List<PlayCard> buyPlaycard(PlayCard p) {
		logger.info("buying playcard service");
		playcardDao.saveAndFlush(p);
		return playcardDao.findAll();
	}


	/*******************************************************************************
	 - Method Name      : getPlaycardById
	 - Input Parameters : Integer id
	 - Return type      : Playcard
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a playcard from the database.
	  ******************************************************************************/ 
	@Override
	public PlayCard getPlaycardById(Integer playcardId) {
		logger.info("getting playcard by Id service");
		Optional<PlayCard> p = playcardDao.findById(playcardId);
		return p.get();
	}

	
	/*******************************************************************************
	 - Method Name      : rechargePlycard
	 - Input Parameters : Playcard p
	 - Return type      : Playcard
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Recharge a playcard in database
	  ******************************************************************************/
	@Override
	public PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException {
		logger.info("recharge playcard service");
		PlayCard a = playcardDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("playcard not found for this id :: " + id));

		p.setPlaycardId(a.getPlaycardId());

		final PlayCard rechargeP = playcardDao.saveAndFlush(p);
		return rechargeP;
	}
	
	/*******************************************************************************
	 - Method Name      : getAllPlaycard
	 - Input Parameters : None
	 - Return type      : List<PlayCard>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieving list of Playcard from Database
	  ******************************************************************************/
	@Override
	public List<PlayCard> getAllPlaycard() {
		logger.info("gettingAll playcard service");
		return playcardDao.findAll();
	}

}
