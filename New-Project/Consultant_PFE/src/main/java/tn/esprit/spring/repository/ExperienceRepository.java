package tn.esprit.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{

	@Query("select e from Experience e where e.consultant.userId = :x and e.nomEntreprise like :y")
	public Page<Experience> rechercheExperienceByConsultant(@Param("x")Long mc,@Param("y")String mc2,Pageable pageable);
}
