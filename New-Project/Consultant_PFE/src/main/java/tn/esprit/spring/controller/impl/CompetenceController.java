package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Competences;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.CompetencesRepository;
import tn.esprit.spring.service.interfaces.IComptence;
import tn.esprit.spring.service.interfaces.ImissionService;

@RestController
@RequestMapping("/api2")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class CompetenceController {
	 @Autowired
		IComptence service;
	 @Autowired
	 CompetencesRepository cr;
	 @GetMapping(value = "/recherchecompsbyconsultant")
	    public Page<Competences> recherchecompetencesbyconsultant(@RequestParam("mc") Long mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.rechercheCompetencesbyconsultant(mc, mc2, page, size);
	    }
	 @GetMapping(value = "/rechav")
	    public Page<Competences> recherchecompetencesAV(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.rechercheCompetencesAV(mc, mc2, page, size);
	    }
	 @GetMapping(value = "/comp")
	    public Page<Competences> rechercheCompetences(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.rechercheCompetences(mc, page, size);
	    }
	 @GetMapping(value = "/comp2")
	    public Page<Competences> rechercheCompetences2(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.rechercheCompetences2(mc, page, size);
	    }
	 @GetMapping(value = "/valide")
	    public Page<Competences> valide(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.valide(mc, page, size);
	    }
	 @PostMapping(value = "/competences/")
	    public Competences addCompetences(@RequestBody Competences c){
	    	return service.addComptence(c);
	    	
	    }
	 @PutMapping(value = "/competences/")
	    public Competences updateCompetences(@RequestBody Competences c){
	    	return service.updateCompetence(c);
	    	
	    }
	 @DeleteMapping(value = "/competences/{compId}")
	    public Competences deleteCompetences(@PathVariable("compId") Long compId ){
		 Competences c=new Competences();
		 c=service.getCompetencesById(compId);
		 c.setConsultant(null);
		 cr.delete(c);
	    	return 		c;

	    	
	    }
}
