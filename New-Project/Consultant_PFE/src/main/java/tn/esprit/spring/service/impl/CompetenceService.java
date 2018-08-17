package tn.esprit.spring.service.impl;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Competences;
import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.repository.CompetencesRepository;
import tn.esprit.spring.service.interfaces.IComptence;
@Component
public class CompetenceService implements IComptence{
 @Autowired
 CompetencesRepository cr;

	@Override
	public Competences addComptence(Competences c) {
		// TODO Auto-generated method stub
		return cr.save(c);
	}

	@Override
	public Competences updateCompetence(Competences c) {
		// TODO Auto-generated method stub
		return cr.save(c);
	}

	@Override
	public Boolean deleteCompetence(Competences c) {
if(c!=null)
		{cr.delete(c);	
		return true;}
else return false;

	}

	@Override
	public Page<Competences> getCompetencesbyConsultant(Long mc, int page, int size) {
		// TODO Auto-generated method stub
		 return cr.getCompetencesByConsultant(mc, new PageRequest(page, size));
	}

	@Override
	public Page<Competences> rechercheCompetencesbyconsultant(Long mc, String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return cr.rechercheCompetencesByConsultant(mc, "%"+mc2+"%",  new PageRequest(page, size));
	}

	@Override
	public Competences getCompetencesById(Long compId) {
		// TODO Auto-generated method stub
		return cr.findOne(compId);
	}

	@Override
	public Page<Competences> rechercheCompetences(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cr.rechercheCompetences("%"+mc+"%", new PageRequest(page, size) );
	}

	@Override
	public Page<Competences> rechercheCompetencesAV(String mc, String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return cr.rechercheCompetencesAV("%"+mc+"%","%"+mc+"%", new PageRequest(page, size) );
	}

	@Override
	public Page<Competences> rechercheCompetences2(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cr.rechercheCompetences2("%"+mc+"%", new PageRequest(page, size) );
	}

	@Override
	public Page<Competences> valide(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return cr.valide("%"+mc+"%", new PageRequest(page, size) );
	}

	

	


	




	

}
