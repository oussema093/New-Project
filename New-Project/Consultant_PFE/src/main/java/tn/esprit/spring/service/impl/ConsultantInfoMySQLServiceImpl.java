package tn.esprit.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ConsultantRepository;
import tn.esprit.spring.service.interfaces.AccountService;
import tn.esprit.spring.service.interfaces.IConsultantInfoService;

@Component
public class ConsultantInfoMySQLServiceImpl implements IConsultantInfoService{
	@Autowired
	ConsultantRepository cons;
	@Autowired
	AccountService accountService;

    byte[] bytesArray = null;

    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Consultant addConsultant(Consultant c) {
	
		c.setEtat(true);
		c.setValidation(false);
		String hashPW=bCryptPasswordEncoder.encode(c.getPassword());
		c.setPassword(hashPW);
		cons.save(c);
		accountService.addRoleToUser("CONSULTANT", c.getUserName());

		return c;
	}

	@Override
	public Consultant updateConsultant(Consultant c) {
		Consultant valide=new Consultant();
		valide=cons.findOne(c.getUserId());
		if(valide.getPassword().equalsIgnoreCase(c.getPassword()))
			return cons.save(c);
		else {
		String hashPW=bCryptPasswordEncoder.encode(c.getPassword());
		c.setPassword(hashPW);
	
		return cons.save(c);
		}
		
	}

	@Override
	public boolean deleteConsultant(Consultant c) {

		cons.delete(c);
		return true;
	}

	@Override
	public Consultant activerConsultant(Long  consultantid) {
		Consultant c=new Consultant();
		c=getConsultantByID(consultantid);
c.setEtat(true);	
return cons.save(c);
	}

	@Override
	public Consultant desactiverConsultant(Long  consultantid) {
		Consultant c=new Consultant();
		c=getConsultantByID(consultantid);
		c.setEtat(false);	
		return cons.save(c);		
	}

	@Override
	public Consultant getConsultantByID(Long consultantid) {
		return cons.findOne(consultantid);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consultant> getAllConsultants() {
List<Consultant>consultants=new ArrayList<>();
cons.findAll().forEach(consultants::add);
		
		return consultants;
	}

	@Override
	public Page<Consultant> chercher(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cons.chercher("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Consultant save(Consultant c) {
		// TODO Auto-generated method stub
		return cons.save(c);
	}

	@Override
	public Consultant findByLogin(String login) {
		//rien
		return cons.findByUserName(login);
	}

	@Override
	public Consultant getConsultantbyLogin(String login) {
		return cons.getConsultantbyLogin(login);
	}

	@Override
	public Consultant payer(long userId) {
Consultant c=cons.findOne(userId);
System.out.println("xxxxxxxxdddddddddd   "+c.getSalaire());

c.setSalaire(c.getSalaire()-10);
		return cons.save(c);
	}

	@Override
	public Page<Consultant> valide(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cons.valide("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Page<Consultant> nonvalide(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cons.nonvalide("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Consultant valider(Long consultantid) {
		Consultant c=new Consultant();
c=cons.findOne(consultantid);
c.setValidation(true);
return cons.save(c);
	}

	@Override
	public Consultant nonvalider(Long consultantid) {
		Consultant c=new Consultant();
		c=cons.findOne(consultantid);
		c.setValidation(false);
		return cons.save(c);
	}

	@Override
	public Consultant addConsultant2(Consultant c) {
		c.setEtat(true);
		//	c.setValidation(false);
			String hashPW=bCryptPasswordEncoder.encode(c.getPassword());
			c.setPassword(hashPW);
			cons.save(c);
			accountService.addRoleToUser("CONSULTANT", c.getUserName());

			return c;
	}
	
	
	

}
