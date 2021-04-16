package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository("adminDao")
public interface adminDao extends JpaRepository<Admin, Integer>{
//	@Query("SELECT a.adminName, g.gameName FROM ADMIN a JOIN a.game g")
//	public String getJoinformation();
	
	
	@Query("select a from Admin a where a.adminId = ?1")
	public Admin findAdminById(int id);

	@Query("select a from Admin a where (a.adminId = ?1 and a.adminPassword = ?2)")
	public Admin authAdmin(int id, String pass);
}
