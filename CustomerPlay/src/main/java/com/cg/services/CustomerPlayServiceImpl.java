package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PlaycardDAO;
import com.cg.entities.Playcard;

@Service
public class CustomerPlayServiceImpl implements CustomerPlayService  {
	
	@Autowired
	PlaycardDAO playdao;
	
	/*public List<Game> getAllGame() {
			
		return gamedao.findAll();
	}*/
	
	public List<Playcard> buyPlaycard(Playcard p) {
		
		playdao.saveAndFlush(p);
		return playdao.findAll();
	}


	public List<Playcard> deletePlaycardById(Integer custId) {
		
		playdao.deleteById(custId);
		return playdao.findAll();
	}

	//@Override
	//public List<Playcard> getPlaycardById(Integer custId) {
	//	playdao.getPlaycardById(custId);
		//return playdao.findAll();
//	}


	@Override
	public List<Playcard> rechargePlaycard(Playcard p) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Playcard> getPlaycardById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
