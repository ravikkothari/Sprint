package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.adminDao;
import com.cg.dto.Grequest;
import com.cg.entity.Admin;
import com.cg.entity.Game;
import com.cg.exceptions.ResourceNotFoundException;


@Service
public class AdminServicesImpl implements AdminServices {

	
	public static final Logger logger = LoggerFactory.getLogger(AdminServicesImpl.class);
	
	
	@Autowired
	adminDao admindao;

	@Override
	public List<Admin> getAllAdmin() {
		return admindao.findAll();
	}

	@Override
	public Admin agamess(Grequest request) {
		return admindao.save(request.getAdmin());
	}

	//create admin 
	
	public Admin createAdmin(Admin s) {
		Admin admin = admindao.save(s);
		if(admin == null) {
			 new ResourceNotFoundException("Can not create admin profile :: ");
		}
		logger.info("create admin service");
		return admin;
	}

	
	public Admin viewAdminById(int id) {
		logger.info("view admin by id service");
		Admin a = admindao.findAdminById(id);
			 
			if(a == null) {
				 new ResourceNotFoundException("Admn not found for this id :: "+ id);
			}
			return a;
	}
	
	
	
	

	
	public boolean deleteAdminById(int id) throws ResourceNotFoundException {
		logger.info("deleteAdminByIdService");
		Admin admin = admindao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		
		admindao.deleteById(id);
		
		if(admin == null)
			return false;
		else
			return true;
	}

	@Override
	public Admin authAdmin(int id, String pass) {
		logger.info("authAdmin service");
		return admindao.authAdmin(id, pass);
	}

	@Override
	public Admin updateAdmin(Admin s, int id) throws ResourceNotFoundException {
		logger.info("update admin service");
		Admin admin = admindao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		
		s.setAdminId(admin.getAdminId());
		
		final Admin updatedA= admindao.save(s);
		return updatedA;
	}
}
