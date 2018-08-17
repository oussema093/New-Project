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

import tn.esprit.spring.entity.Experience;
import tn.esprit.spring.service.interfaces.IExperience;

@RestController
@RequestMapping("/api3")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ExperienceController {
	 @Autowired
		IExperience service;
	 @GetMapping(value = "/rechercheexpsbyconsultant")
	    public Page<Experience> rechercheexperiencesbyconsultant(@RequestParam("mc") Long mc,@RequestParam(name="mc2",defaultValue="") String mc2,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
	    	
	    	
	    	return service.rechercheExperiencebyconsultant(mc, mc2, page, size);
	    }
	 @PostMapping(value = "/experiences/")
	    public Experience addCompetences(@RequestBody Experience exp){
	    	return service.addExperience(exp);
	    	
	    }
	 @PutMapping(value = "/experiences/")
	    public Experience updateCompetences(@RequestBody Experience exp){
	    	return service.updateExperience(exp);
	    	
	    }
	 @DeleteMapping(value = "/experiences/{experienceId}")
	    public Boolean deleteCompetences(@PathVariable("experienceId") Long experienceId){
		 Experience exp=new Experience();
		 exp=service.getExperienceById(experienceId);
	    	return service.deleteExperience(exp);
	    	
	    }
}
