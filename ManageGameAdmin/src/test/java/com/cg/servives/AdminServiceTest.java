package com.cg.servives;

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

import com.cg.AdminMSApplication;
import com.cg.dao.AdminDao;
import com.cg.services.AdminServices;
import com.cg.entity.Admin;




@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdminMSApplication.class)
@WebMvcTest(value = AdminServices.class)
public class AdminServiceTest {

	@Autowired
	private AdminServices adminServices;

	@MockBean
	private AdminDao adminDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCreateAdminController() throws Exception {
		Admin admin = getAdmin();
	   
	    Mockito.when(adminDao.save(Mockito.any(Admin.class))).thenReturn(admin);
	    
	    Admin result = adminServices.createAdmin(admin);
	    
	    assertThat(admin).isEqualTo(result);

	}
	
	@Test
	void testViewAdminByIdController() throws Exception {
		
		Admin admin = getAdmin();

	    Mockito.when(adminDao.findAdminById(Mockito.anyInt())).thenReturn(admin);

	    Admin result = adminServices.viewAdminById(101);
	    
	    assertThat(admin).isEqualTo(result);

	}
	

	@Test
	void testUpdateAdminController() throws Exception {
		
		Optional<Admin> a = Optional.of(getAdmin());
		
		
		Admin admin = getAdmin();
	  
	    Mockito.when(adminDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.when(adminDao.save(Mockito.any(Admin.class))).thenReturn(admin);
	    
	    Admin result = adminServices.updateAdmin(admin, 101);
	    
	    assertThat(admin).isEqualTo(result);
	}

	@Test
	void testDeleteAdminByIdController() throws Exception {
		Optional<Admin> a = Optional.of(getAdmin());

	    boolean b = true;
	    
	    Mockito.when(adminDao.findById(Mockito.anyInt())).thenReturn(a);
	    Mockito.doNothing().when(adminDao).deleteById(Mockito.anyInt());
	    
	    boolean result = adminServices.deleteAdminById(101);
	    
	    assertThat(b).isEqualTo(result);
	}
	
	@Test
	void testListAllAdminController() throws Exception {

		List<Admin> a = new ArrayList<Admin>();
		
		Admin admin = getAdmin();
		a.add(admin);
	    
	    Mockito.when(adminDao.findAll()).thenReturn(a);
	   
	    List<Admin> result = adminServices.getAllAdmin();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	private Admin getAdmin() {
		Admin a = new Admin();
		
		a.setAdminId(101);
		a.setAdminEmail("abc");
		a.setAdminName("abc");
		a.setAdminPassword("abc");
		
		return a;
	}

}
