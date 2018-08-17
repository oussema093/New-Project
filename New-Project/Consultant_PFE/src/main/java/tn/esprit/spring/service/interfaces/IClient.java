package tn.esprit.spring.service.interfaces;

import tn.esprit.spring.entity.Client;

public interface IClient {

	public Client addClient(Client c);
	public Client findClientbyUserName(String userName);
}
