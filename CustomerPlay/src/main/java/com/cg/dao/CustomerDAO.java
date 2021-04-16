package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;


@Repository("custDao")
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.cust_Id = ?1")
	public Customer findCustomerById(Long id);

	@Query("select a from Customer a where (c.cust_Id = ?1 and c.password = ?2)")
	public Customer authCustomer(long id, String pass);

}

