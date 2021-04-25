package com.cg.services;

import java.util.List;

import com.cg.entity.PlayCard;
import com.cg.exceptions.ResourceNotFoundException;

public interface PlaycardService {

	List<PlayCard> buyPlaycard(PlayCard p);

	PlayCard getPlaycardById(Integer playcardId);

	List<PlayCard> getAllPlaycard();

	PlayCard rechargePlaycard(PlayCard p, int id) throws ResourceNotFoundException;
}
