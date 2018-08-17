package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Partenaire;
import tn.esprit.spring.repository.PartenaireRepository;
import tn.esprit.spring.service.interfaces.IPartenaire;
@Component
public class PartenaireService implements IPartenaire{
	@Autowired
	PartenaireRepository pr;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Partenaire addPartenaire(Partenaire p) {
		String hashPW=bCryptPasswordEncoder.encode(p.getPassword());
		p.setPassword(hashPW);
		return pr.save(p);
	}

}
