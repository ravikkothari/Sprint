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

import com.cg.dao.ComplainDao;

import com.cg.entity.Complain;
import com.cg.service.ComplainService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerCareMicroService.class)
@WebMvcTest(value = Complain.class)
public class ComplainServiceTest {

	@Autowired
	private ComplainService compServices;

	@MockBean
	private ComplainDao compDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCreateComplainController() throws Exception {
		Complain complain = getComplain();
	   
	    Mockito.when(compDao.save(Mockito.any(Complain.class))).thenReturn(complain);
	    
	    Complain result = compServices.createComplain(complain);
	    
	    assertThat(complain).isEqualTo(result);

	}
	
	@Test
	void testViewComplainByIdController() throws Exception {
		
		Complain complain = getComplain();

	    Mockito.when(compDao.findComplainById(Mockito.anyInt())).thenReturn(complain);

	    Complain result = compServices.viewComplainById(101);
	    
	    assertThat(complain).isEqualTo(result);

	}
	
	@Test
	void testUpdateComplainController() throws Exception {
		
		Optional<Complain> a = Optional.of(getComplain());
		
		
		Complain complain = getComplain();
	  
	    Mockito.when(compDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.when(compDao.save(Mockito.any(Complain.class))).thenReturn(complain);
	    
	    Complain result = compServices.updateComplain(complain, 101);
	    
	    assertThat(complain).isEqualTo(result);
	}
	
	@Test
	void testDeleteComplainByIdController() throws Exception {
		Optional<Complain> a = Optional.of(getComplain());
	    boolean b = true;
	    
	    Mockito.when(compDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.doNothing().when(compDao).deleteById(Mockito.anyInt());
	    
	    boolean result = compServices.deleteComplainById(101);
	    
	    assertThat(b).isEqualTo(result);
	}
	
	@Test
	void testListAllComplainController() throws Exception {

		List<Complain> a = new ArrayList<Complain>();
		
		Complain complain = getComplain();
		a.add(complain);
	    
	    Mockito.when(compDao.findAll()).thenReturn(a);
	   
	    List<Complain> result = compServices.getAllComplaints();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	private Complain getComplain() {
		Complain a = new Complain();
		
		a.setComplaintID(101);
		a.setUserid(1);
		a.setIssue("abc");
		
		return a;
	}
}
