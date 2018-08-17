package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Recruteur;
import tn.esprit.spring.repository.RecruteurRepository;
import tn.esprit.spring.service.interfaces.IRecruteur;
@Component
public class RecruteurService implements IRecruteur{

@Autowired
RecruteurRepository rr;
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Recruteur addRecruteur(Recruteur r) {
		String hashPW=bCryptPasswordEncoder.encode(r.getPassword());
		r.setPassword(hashPW);
		return rr.save(r);
	}

}
