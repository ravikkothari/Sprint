package com.cg.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerMsApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = Customer.class)
public class CustomerTest {

	private Customer customer = new Customer();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCustomerId() {
		int mockId = 11;
		customer.setCustomerId(mockId);
		int id = customer.getCustomerId();

		assertThat(id).isEqualTo(mockId);

	}

	@Test
	void testSetCustomerId() {
		int mockId = 11;
		customer.setCustomerId(mockId);
		int id = customer.getCustomerId();

		assertThat(id).isEqualTo(mockId);

	}

	@Test
	void testGetName() {
		String mockName = "Roy";
		customer.setCustomerName(mockName);
		String name = customer.getCustomerName();

		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "Roy";
		customer.setCustomerName(mockName);
		String name = customer.getCustomerName();

		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testGetAge() {
		int mockId = 11;
		customer.setAge(mockId);
		int id = customer.getAge();

		assertThat(id).isEqualTo(mockId);

	}

	@Test
	void testSetAge() {
		int mockId = 11;
		customer.setAge(mockId);
		int id = customer.getAge();

		assertThat(id).isEqualTo(mockId);

	}
}
