package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerMsApplication;
import com.cg.dao.CustomerDAO;
import com.cg.entity.Customer;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = CustomerService.class)
public class CustomerService {
	
	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerDAO customerdao;
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
