package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.interfaces.IClient;

@RestController
@RequestMapping("/apicl")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ClientController {
	@Autowired
	IClient service;

	 @GetMapping(value = "/clientlogin")
	    public Client getClientbyLogin(@RequestParam(name="login") String login) 
	 {

		 return service.findClientbyUserName(login);
	 }
}
