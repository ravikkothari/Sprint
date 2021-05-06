package com.cg.dao;

/**
-File Name          : ComplainDao
-Author Name        : Capgemini
-Description        : Interface for Complain Repository
-Creation Date		: 12/04/2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Complain;

@Repository("compDao")
public interface ComplainDao extends JpaRepository<Complain, Integer>{
	
	@Query("select a from Complain a where a.complaintID = ?1")
	public Complain findComplainById(int id);
}
