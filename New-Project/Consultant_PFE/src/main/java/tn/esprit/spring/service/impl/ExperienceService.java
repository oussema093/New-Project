package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Experience;
import tn.esprit.spring.repository.ExperienceRepository;
import tn.esprit.spring.service.interfaces.IExperience;
@Component
public class ExperienceService implements IExperience {
@Autowired
ExperienceRepository exprep;
	@Override
	public Experience addExperience(Experience exp) {
		// TODO Auto-generated method stub
		return exprep.save(exp);
	}

	@Override
	public Experience updateExperience(Experience exp) {
		// TODO Auto-generated method stub
		return exprep.save(exp);
	}

	@Override
	public Boolean deleteExperience(Experience exp) {
exprep.delete(exp);		
return true;
	}

	@Override
	public Page<Experience> rechercheExperiencebyconsultant(Long mc, String mc2, int page, int size) {
		// TODO Auto-generated method stub
		return exprep.rechercheExperienceByConsultant(mc, "%"+mc2+"%",  new PageRequest(page, size));
	}

	@Override
	public Experience getExperienceById(Long idExp) {
		// TODO Auto-generated method stub
		return exprep.findOne(idExp);
	}



}
