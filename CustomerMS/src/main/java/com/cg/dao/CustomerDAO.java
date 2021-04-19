package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository("CustomerDAO")
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	@Query("select c from Customer c where c.customerId = ?1")
	public Customer findCustomerById(int l);

}
