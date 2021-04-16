package com.cg.services;

import com.cg.entities.CustomerPlaycard;
import com.cg.exception.PlaycardNotFoundException;

public interface CustomerPlaycardService
{
	CustomerPlaycard buyPlaycardService(CustomerPlaycard p);

	boolean deletePlaycardByIdService(long id) throws PlaycardNotFoundException;

	CustomerPlaycard rechargePlaycardService(CustomerPlaycard p, long id) throws PlaycardNotFoundException;  
	
}
