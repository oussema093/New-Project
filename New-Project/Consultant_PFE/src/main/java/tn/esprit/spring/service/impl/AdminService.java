package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.repository.AdminRepository;
import tn.esprit.spring.service.interfaces.IAdminService;
@Component
public class AdminService implements IAdminService{
	@Autowired
	AdminRepository adminrepo;
	@Override
	public Admin addAdmin(Admin a) {
		//adminrepo.save(a);
		return adminrepo.save(a);
	}



	


}
