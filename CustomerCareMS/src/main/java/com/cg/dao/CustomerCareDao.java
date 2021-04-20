package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.entity.CustomerCare;

@Repository("custDao")
public interface CustomerCareDao extends JpaRepository<CustomerCare, Integer>{
	
	@Query("select a from CustomerCare a where a.customerCareid = ?1")
	public CustomerCare findCustomercareById(int id);
}
