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
@WebMvcTest(value = CustomerCare.class)
public class CustomerCareTest {

private CustomerCare custcare = new CustomerCare();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetcustcareId() {
		int mockId = 101;
		custcare.setCustomerCareid(mockId);
		int id = custcare.getCustomerCareid();
		
		assertThat(id).isEqualTo(mockId);
	    
	}
	
	@Test
	void testSetcustcareId() {
		int mockId = 101;
		custcare.setCustomerCareid(mockId);
		int id = custcare.getCustomerCareid();
		
		assertThat(id).isEqualTo(mockId);
	}
	

	@Test
	void testGetcustcarename() {
		String mockName = "Ravi";
		custcare.setCustomerName(mockName);
		String name = custcare.getCustomerName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetcustcarename() {
		String mockName = "Ravi";
		custcare.setCustomerName(mockName);
		String name = custcare.getCustomerName();
		
		assertThat(name).isEqualTo(mockName);
	}
}
