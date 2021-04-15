package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;

@Repository("custDao")
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}

