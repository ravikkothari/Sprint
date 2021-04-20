package com.cg.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerCareMicroService;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerCareMicroService.class)
@WebMvcTest(value = Complain.class)
public class ComplainTest {

private Complain complain = new Complain();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetComplainId() {
		int mockId = 101;
		complain.setComplaintID(mockId);
		int id = complain.getComplaintID();
		
		assertThat(id).isEqualTo(mockId);
	    
	}
	
	@Test
	void testSetComplainId() {
		int mockId = 101;
		complain.setComplaintID(mockId);
		int id = complain.getComplaintID();
		
		assertThat(id).isEqualTo(mockId);
	}
	
	@Test
	void testGetuserId() {
		int mockId = 101;
		complain.setUserid(mockId);
		int id = complain.getUserid();
		
		assertThat(id).isEqualTo(mockId);
	    
	}
	
	@Test
	void testSetuserId() {
		int mockId = 101;
		complain.setUserid(mockId);
		int id = complain.getUserid();
		
		assertThat(id).isEqualTo(mockId);
	}
	
	@Test
	void testGetissue() {
		String mockName = "Ravi";
		complain.setIssue(mockName);
		String name = complain.getissue();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetissue() {
		String mockName = "Ravi";
		complain.setIssue(mockName);
		String name = complain.getissue();
		
		assertThat(name).isEqualTo(mockName);
	}
	
	
	
}
