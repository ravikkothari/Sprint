package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CartDAO;
import com.cg.entities.Cart;



@Service
public class CustomerPlayServiceImpl implements CustomerPlayService  {
	
	@Autowired
	CartDAO cartdao;
	
	
	public List<Cart> buyPlaycard(Cart p) {
		cartdao.saveAndFlush(p);
		return cartdao.findAll();
	}
	
	
	@Override
	public Cart rechargePlaycardById(Integer playcardId) {
		Optional<Cart> p=cartdao.findById(playcardId);
		return p.get();
	}
	
	


	
}
