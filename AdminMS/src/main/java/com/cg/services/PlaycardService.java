package com.cg.services;

import java.util.List;

import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;

/**
-File Name          : PlaycardServices
-Author Name        : Capgemini
-Description        : Playcard Service Interface 
-Creation Date		: 14/04/2021
*/


public interface PlaycardService {

	public List<PlayCard> addPlaycard(PlayCard p);
	
	public PlayCard getPlaycardById(Integer playcardId);
	
	public PlayCard updatePlaycard(PlayCard p, int id) throws ResourceNotFoundException;
	
	public List<PlayCard> getAllPlaycard();
	
	public boolean deletePlaycardById(Integer  playcardId) throws ResourceNotFoundException;
}
