package tn.esprit.spring.controller.impl;

import java.io.Console;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.spring.entity.Competences;
import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaces.IComptence;
import tn.esprit.spring.service.interfaces.IConsultantInfoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ConsultantController {
	@Autowired
	IConsultantInfoService service;
	@Autowired
	IComptence comp;
	
	   @GetMapping(value = "/consultant/{consultantid}")
	    public ResponseEntity<Consultant> getconsutant(@PathVariable Long consultantid) {
	    	
	    	
	    	return new ResponseEntity<>(service.getConsultantByID(consultantid), HttpStatus.OK); //TODO
	    }
	   
	    
		@PostMapping(value = "/consultant/")
	    public Consultant addClient(@RequestBody Consultant c){

			
	    	service.addConsultant(c);
			
	    	return c;

	    	
	    }
		
		@DeleteMapping(value = "/consultant/{consultantid}")
	    public boolean deleteConsultant(@PathVariable("consultantid") Long consultantid){
	    	
	    	Consultant c=new Consultant();
	    	c=service.getConsultantByID(consultantid);
	   
	    	
	    	return service.deleteConsultant(c);
	    }
		
		@GetMapping(value = "/consultant/")
	    public List<Consultant> getAllConsultant(){
	    	
	    	
	    	return service.getAllConsultants();
	    }
		
		
		@PutMapping(value = "/consultant/")
	    public Consultant updateConsultant(@RequestBody Consultant c){
	    	
	    	return service.updateConsultant(c);
	    }
		
		
		@PutMapping(value = "/consultant/activer/{consultantid}")
	    public Consultant activerConsultant(@PathVariable Long consultantid){
	    	
	    	return service.activerConsultant(consultantid);
	    }
		
		@PutMapping(value = "/consultant/desactiver/{consultantid}")
	    public Consultant desactiverConsultant(@PathVariable Long consultantid){
	    	
	    	 return service.desactiverConsultant(consultantid);
	    }
		 @GetMapping(value = "/chercherconsultant")
		    public Page<Consultant> chercher(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		    	
		    	
		    	return service.chercher(mc, page, size) ;//TODO
		    }
		 @GetMapping(value = "/valide")
		    public Page<Consultant> valide(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		    	
		    	
		    	return service.valide(mc, page, size) ;//TODO
		    }
		 @GetMapping(value = "/nonvalide")
		    public Page<Consultant> nonvalide(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		    	
		    	
		    	return service.nonvalide(mc, page, size) ;//TODO
		    }
		
		 @GetMapping(value = "/consultantlogin")
		    public Consultant getConsultantbyLogin(@RequestParam(name="login") String login) 
		 {

			 return service.getConsultantbyLogin(login);
		 }
		 @PutMapping(value = "/consultant/payer/{consultantid}")
		    public Consultant payer(@PathVariable Long consultantid){
		    	 return service.payer(consultantid);
		    }
		 @PutMapping(value = "/consultant/valider/{consultantid}")
		    public Consultant valider(@PathVariable Long consultantid){
		    	
		    	return service.valider(consultantid);
		    }
			
			@PutMapping(value = "/consultant/nonvalider/{consultantid}")
		    public Consultant nonvalider(@PathVariable Long consultantid){
		    	
		    	 return service.nonvalider(consultantid);
		    }
	
}
