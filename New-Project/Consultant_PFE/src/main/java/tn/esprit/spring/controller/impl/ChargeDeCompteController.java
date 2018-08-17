package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.ChargeDeCompte;
import tn.esprit.spring.service.interfaces.IChargeDeCompte;

@RestController
@RequestMapping("/apicc")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ChargeDeCompteController {
	@Autowired
	IChargeDeCompte service;
	@GetMapping(value = "/cclogin")
    public ChargeDeCompte getChargeDeComptebyLogin(@RequestParam(name="login") String login) 
 {

	 return service.findChargeCompteByUserName(login);
 }
}
