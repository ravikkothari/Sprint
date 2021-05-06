package com.cg.dao;
/**
-File Name          : CustomerDAO
-Author Name        : Capgemini
-Description        : Interface for Customer Repository
-Creation Date		: 12/04/2021
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository("CustomerDAO")
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.customerId = ?1")
	public Customer findCustomerById(int l);

}
