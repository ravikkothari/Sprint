package com.cg.services;
/**
-File Name          : PlaycardService
-Author Name        : Capgemini
-Description        : Playcard Service Interface 
-Creation Date		: 14/04/2021
*/

import java.util.List;

import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;

public interface PlaycardService {

	List<PlayCard> buyPlaycard(PlayCard p);

	PlayCard getPlaycardById(Integer playcardId);

	List<PlayCard> getAllPlaycard();

	PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException;
}
