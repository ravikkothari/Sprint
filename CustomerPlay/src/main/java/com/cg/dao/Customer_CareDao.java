package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer_Care;
@Repository
public interface Customer_CareDao extends JpaRepository<Customer_Care, Integer>{

}

