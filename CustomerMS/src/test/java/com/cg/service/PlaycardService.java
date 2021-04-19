package com.cg.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerMsApplication;
import com.cg.dao.CustomerDAO;




@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = PlaycardService.class)

public class PlaycardService {




	@Autowired
	private PlaycardService playcardService;

	@MockBean
	private CustomerDAO customerDao;
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	    
	    


}
