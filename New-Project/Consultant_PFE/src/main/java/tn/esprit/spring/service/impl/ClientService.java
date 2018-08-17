package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.interfaces.IClient;
@Component
public class ClientService implements IClient{
	@Autowired 
	ClientRepository cr;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Client addClient(Client c) {
		String hashPW=bCryptPasswordEncoder.encode(c.getPassword());
		c.setPassword(hashPW);
		return cr.save(c);
	}

	@Override
	public Client findClientbyUserName(String userName) {
		// TODO Auto-generated method stub
		return cr.getClientByUserName(userName);
	}

}
