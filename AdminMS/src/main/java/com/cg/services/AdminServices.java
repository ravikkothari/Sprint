package com.cg.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cg.dto.Grequest;
import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.entity.Game;
import com.cg.exceptions.ResourceNotFoundException;

public interface AdminServices {

	public List<Admin> getAllAdmin();
	
	public Admin agamess(Grequest request);
	
	public Admin createAdmin(Admin s);
	public Admin viewAdminById(int id);
	public Admin updateAdmin(Admin s, int id) throws ResourceNotFoundException;
	public boolean deleteAdminById(int id) throws ResourceNotFoundException;
	public String createCustomer(Customer c);

	public Admin authAdmin(int id, String pass);
}
