package com.cg.services;

import java.util.List;

import com.cg.entity.PlayCard;



public interface PlaycardService {

	public List<PlayCard> addPlaycard(PlayCard p);
	
	public PlayCard getPlaycardById(Integer playcardId);
	
	public List<PlayCard> updatePlaycard(PlayCard p);
	
	public List<PlayCard> getAllPlaycard();
	
	public List<PlayCard> deletePlaycardById(Integer  playcardId);
}
