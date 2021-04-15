package com.cg.services;

import java.util.List;

import com.cg.entities.Playcard;

public interface CustomerPlayService {

	List<Playcard> getPlaycardById(Integer id);

	List<Playcard> deletePlaycardById(Integer id);

	List<Playcard> rechargePlaycard(Playcard p);



}
