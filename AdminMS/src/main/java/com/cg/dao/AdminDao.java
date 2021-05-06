package com.cg.dao;

/**
-File Name          : AdminDao
-Author Name        : Capgemini
-Description        : Interface for Admin Repository
-Creation Date		: 12/04/2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository("adminDao")
public interface AdminDao extends JpaRepository<Admin, Integer>{
//	@Query("SELECT a.adminName, g.gameName FROM ADMIN a JOIN a.game g")
//	public String getJoinformation();
	
	/*******************************************************************************
	 - Method Name      : findAdminById
	 - Input Parameters : Integer id
	 - Return type      : Admin
	 - Author           : Capgemini
	 - Creation Date    : 12/04/2021
	 - Description      : finding Admin from Database by id
	  ******************************************************************************/ 
	
	@Query("select a from Admin a where a.adminId = ?1")
	public Admin findAdminById(int id);

	/*******************************************************************************
	 - Method Name      : authAdmin
	 - Input Parameters : Integer id , String pass
	 - Return type      : Admin
	 - Author           : Capgemini
	 - Creation Date    : 12/04/2021
	 - Description      : Authenticate Customer from Database
	  ******************************************************************************/ 
	@Query("select a from Admin a where (a.adminId = ?1 and a.adminPassword = ?2)")
	public Admin authAdmin(int id, String pass);
	
}
