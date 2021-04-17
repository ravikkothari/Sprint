package com.cg.services;

import java.util.List;

import com.cg.entities.PlayCard;
import com.cg.exception.ResourceNotFoundException;





public interface PlaycardService {

	public List<PlayCard> buyPlaycard(PlayCard p);
	
	public PlayCard getPlaycardById(Integer playcardId);
	
	public PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException;
	
	public List<PlayCard> getAllPlaycard();
	
	public boolean deletePlaycardById(Integer  playcardId) throws ResourceNotFoundException;
}
