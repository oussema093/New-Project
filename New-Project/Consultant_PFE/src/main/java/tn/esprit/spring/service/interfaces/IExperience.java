package tn.esprit.spring.service.interfaces;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Experience;

public interface IExperience {

	public Experience addExperience(Experience exp);
	public Experience updateExperience(Experience exp);
	public Boolean deleteExperience(Experience exp);
	  public Page <Experience>rechercheExperiencebyconsultant(Long mc,String mc2,int page,int size);
	  public Experience getExperienceById(Long idExp);

}
