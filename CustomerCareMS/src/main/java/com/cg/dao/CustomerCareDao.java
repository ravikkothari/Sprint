package com.cg.dao;
/**
-File Name          : CustomerCareDao
-Author Name        : Capgemini
-Description        : Interface for Customer Repository
-Creation Date		: 12/04/2021
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.entity.CustomerCare;

@Repository("custDao")
public interface CustomerCareDao extends JpaRepository<CustomerCare, Integer>{
	
	@Query("select a from CustomerCare a where a.customerCareid = ?1")
	public CustomerCare findCustomercareById(int id);
}
