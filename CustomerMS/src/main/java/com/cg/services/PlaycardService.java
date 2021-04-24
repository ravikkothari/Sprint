package com.cg.services;

import java.util.List;

import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;



public interface PlaycardService {

	public List<PlayCard> buyPlaycard(PlayCard p);
	
	public PlayCard getPlaycardById(Integer playcardId);
	
	public List<PlayCard> getAllPlaycard();

	public PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException;
}
