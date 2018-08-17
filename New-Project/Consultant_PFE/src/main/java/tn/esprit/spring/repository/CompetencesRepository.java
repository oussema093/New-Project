package tn.esprit.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Competences;
import tn.esprit.spring.entity.Mission;


public interface CompetencesRepository  extends CrudRepository<Competences, Long> {
	@Query("select c from Competences c where c.consultant.userId like :x")
	public Page<Competences> getCompetencesByConsultant(@Param("x")Long mc,Pageable pageable);
	@Query("select c from Competences c where c.consultant.userId = :x and c.infoCompetences like :y")
	public Page<Competences> rechercheCompetencesByConsultant(@Param("x")Long mc,@Param("y")String mc2,Pageable pageable);
	@Query("select c from Competences c where c.infoCompetences like :y")
	public Page<Competences> rechercheCompetences(@Param("y")String mc,Pageable pageable);
	@Query("select c from Competences c where c.infoCompetences like :y and c.consultant.nomSociete like :x")
	public Page<Competences> rechercheCompetencesAV(@Param("y")String mc,@Param("x")String mc2,Pageable pageable);
	@Query("select c from Competences c where c.consultant.nomSociete like :y")
	public Page<Competences> rechercheCompetences2(@Param("y")String mc,Pageable pageable);
	@Query("select c from Competences c where c.infoCompetences like :y and c.consultant.validation=true")
	public Page<Competences> valide(@Param("y")String mc,Pageable pageable);
	
}
