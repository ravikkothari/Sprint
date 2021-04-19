package com.cg.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.AdminMSApplication;
import com.cg.entity.Admin;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdminMSApplication.class)
@WebMvcTest(value = Admin.class)
public class AdminTest {

	private Admin admin = new Admin();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testGetAdminId() {
		int mockId = 101;
		admin.setAdminId(mockId);
		int id = admin.getAdminId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}
	
	@Test
	void testSetAdminId() {
		int mockId = 101;
		admin.setAdminId(mockId);
		int id = admin.getAdminId();
		
		assertThat(id).isEqualTo(mockId);
	}
	
	@Test
	void testGetName() {
		String mockName = "Ravi";
		admin.setAdminName(mockName);
		String name = admin.getAdminName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "Ravi";
		admin.setAdminName(mockName);
		String name = admin.getAdminName();
		
		assertThat(name).isEqualTo(mockName);
	}
	
	@Test
	void testGetEmailId() {
		String mockEmail = "Ravi@gmail.com";
		admin.setAdminEmail(mockEmail);
		String email = admin.getAdminEmail();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testSetEmailId() {
		String mockEmail = "Ravi@gmail.com";
		admin.setAdminEmail(mockEmail);
		String email = admin.getAdminEmail();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testGetPassword() {
		String mockPass = "Ravi123";
		admin.setAdminPassword(mockPass);
		String pass = admin.getAdminPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "Ravi123";
		admin.setAdminPassword(mockPass);
		String pass = admin.getAdminPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}
}
