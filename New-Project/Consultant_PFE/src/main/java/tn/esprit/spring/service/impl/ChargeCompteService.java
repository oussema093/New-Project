package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.ChargeDeCompte;
import tn.esprit.spring.repository.ChargeDeCompteRepository;
import tn.esprit.spring.service.interfaces.IChargeDeCompte;
@Component
public class ChargeCompteService implements IChargeDeCompte{
@Autowired
ChargeDeCompteRepository ccr;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public ChargeDeCompte findChargeCompteByUserName(String userName) {
		// TODO Auto-generated method stub
		return ccr.getChargeDeCompte(userName);
	}
	@Override
	public ChargeDeCompte addcc(ChargeDeCompte chargedecompte) {
		String hashPW=bCryptPasswordEncoder.encode(chargedecompte.getPassword());
		chargedecompte.setPassword(hashPW);
		return ccr.save(chargedecompte);
	}

}
