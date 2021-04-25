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
import com.cg.services.CustomerService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = CustomerService.class)
public class CustomerServiceTest {

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

	@Test
	void testCreateAdminController() throws Exception {
		Customer customer = getCustomer();

		Mockito.when(customerdao.save(Mockito.any(Customer.class))).thenReturn(customer);

		Customer result = customerService.createCustomer(customer);

		assertThat(customer).isEqualTo(result);

	}

	@Test
	void testViewCustomerByIdController() throws Exception {

		Customer customer = getCustomer();

		Mockito.when(customerdao.findCustomerById(Mockito.anyInt())).thenReturn(customer);

		Customer result = customerService.viewCustomerById(101);

		assertThat(customer).isEqualTo(result);

	}

	private Customer getCustomer() {
		Customer c = new Customer();

		c.setCustomerId(101);
		c.setCustomerName("abc");
		c.setAge(11);

		return c;
	}

}
