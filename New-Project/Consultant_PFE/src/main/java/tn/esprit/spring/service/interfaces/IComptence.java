package tn.esprit.spring.service.interfaces;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Competences;
import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.entity.Mission;

public interface IComptence {

	public Competences addComptence(Competences c);
	public Competences updateCompetence(Competences c);
	public Boolean deleteCompetence(Competences c);
	public Page <Competences>getCompetencesbyConsultant(Long mc,int page,int size);
	  public Page <Competences>rechercheCompetencesbyconsultant(Long mc,String mc2,int page,int size);
	  public Competences getCompetencesById(Long compId);
	  
	  public Page <Competences>rechercheCompetences(String mc,int page,int size);
	  public Page <Competences>rechercheCompetencesAV(String mc,String mc2,int page,int size);
	  public Page <Competences>rechercheCompetences2(String mc,int page,int size);
	  public Page <Competences>valide(String mc,int page,int size);


}
