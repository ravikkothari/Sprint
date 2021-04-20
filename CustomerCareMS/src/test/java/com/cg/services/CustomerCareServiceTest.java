package com.cg.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.cg.CustomerCareMicroService;
import com.cg.dao.CustomerCareDao;
import com.cg.entity.CustomerCare;
import com.cg.service.CustomerCareService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerCareMicroService.class)
@WebMvcTest(value = CustomerCare.class)
public class CustomerCareServiceTest {

	@Autowired
	CustomerCareService custServices;

	@MockBean
	CustomerCareDao custDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testcreateComplainController() throws Exception {
		CustomerCare custcare = getCustcare();
	   
	    Mockito.when(custDao.save(Mockito.any(CustomerCare.class))).thenReturn(custcare);
	    
	    CustomerCare result = custServices.createCustomerCare(custcare);
	    
	    assertThat(custcare).isEqualTo(result);

	}
	
	@Test
	void testviewCustomercareByIdController() throws Exception {
		
		CustomerCare custcare = getCustcare();

	    Mockito.when(custDao.findCustomercareById(Mockito.anyInt())).thenReturn(custcare);

	    CustomerCare result = custServices.viewCustomercareById(101);
	    
	    assertThat(custcare).isEqualTo(result);

	}
	
	@Test
	void testupdateCustomercareController() throws Exception {
		
		Optional<CustomerCare> a = Optional.of(getCustcare());
		
		
		CustomerCare custcare = getCustcare();
	  
	    Mockito.when(custDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.when(custDao.save(Mockito.any(CustomerCare.class))).thenReturn(custcare);
	    
	    CustomerCare result = custServices.updateCustomercare(custcare, 101);
	    
	    assertThat(custcare).isEqualTo(result);
	}
	
	@Test
	void testdeleteCustomercareByIdController() throws Exception {
		Optional<CustomerCare> a = Optional.of(getCustcare());
	    boolean b = true;
	    
	    Mockito.when(custDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.doNothing().when(custDao).deleteById(Mockito.anyInt());
	    
	    boolean result = custServices.deleteCustomercareById(101);
	    
	    assertThat(b).isEqualTo(result);
	}
	
	@Test
	void testgetAllComp() throws Exception {

		List<CustomerCare> a = new ArrayList<CustomerCare>();
		
		CustomerCare custcare = getCustcare();
		a.add(custcare);
	    
	    Mockito.when(custDao.findAll()).thenReturn(a);
	   
	    List<CustomerCare> result = custServices.getAllCustomerCare();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	private CustomerCare getCustcare() {
		CustomerCare a = new CustomerCare();
		
		a.setCustomerCareid(101);
		a.setCustomerName("abc");
		
		return a;
	}
}
