package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entities.CustomerPlaycard;




public interface CustomerPlaycardDAO  extends JpaRepository<CustomerPlaycard, Integer>{

	@Query("select p from CustomerPlaycard p where playcardId = ?1")
	public CustomerPlaycard findById(long id);
	
	
	@Query("delete p from CustomerPlaycard p where playcardId= ?1")
	public CustomerPlaycard deleteById(long id);

	




}
