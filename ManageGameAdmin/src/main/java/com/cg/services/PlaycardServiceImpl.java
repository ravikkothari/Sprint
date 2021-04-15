package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PlaycardDao;
import com.cg.entity.PlayCard;

@Service
public class PlaycardServiceImpl implements PlaycardService{

	
	@Autowired
	PlaycardDao playcardDao;
	
	public List<PlayCard> addPlaycard(PlayCard p) {
		playcardDao.saveAndFlush(p);
		return playcardDao.findAll();
	}

	@Override
	public PlayCard getPlaycardById(Integer playcardId) {
		Optional<PlayCard> p=playcardDao.findById(playcardId);
		return p.get();
	}

	@Override
	public List<PlayCard> updatePlaycard(PlayCard p) {
		playcardDao.saveAndFlush(p);
		return playcardDao.findAll();
	}

	@Override
	public List<PlayCard> getAllPlaycard() {
		return playcardDao.findAll();
	}

	@Override
	public List<PlayCard> deletePlaycardById(Integer playcardId) {
		playcardDao.deleteById(playcardId);
		return playcardDao.findAll();
	}
	
	

}
