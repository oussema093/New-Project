package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Mission;


public interface MissionRepository extends CrudRepository<Mission, Long>{
	@Query("select m from Mission m where m.description like :x")
	public Page<Mission> chercher(@Param("x")String mc,Pageable pageable);
	
	@Query("select m from Mission m where m.consultant.userId like :x")
	public Page<Mission> getMissionByConsultant(@Param("x")Long mc,Pageable pageable);
	
	@Query("select m from Mission m where m.consultant.userId = :x and m.description like :y")
	public Page<Mission> rechercheMissionByConsultant(@Param("x")Long mc,@Param("y")String mc2,Pageable pageable);
	
	@Query("select m from Mission m where m.dateFin< :x")
	public List<Mission> rechercheMissionDelai(@Param("x")Date mc);
	
	@Query("select m from Mission m where m.client.userId = :x and m.description like :y")
	public Page<Mission> rechercheMissionByClient(@Param("x")Long mc,@Param("y")String mc2,Pageable pageable);
	@Query("select m from Mission m where m.chargedecompte.userId = :x and m.description like :y")
	public Page<Mission> rechercheMissionByChargeCompte(@Param("x")Long mc,@Param("y")String mc2,Pageable pageable);
	@Query("select m from Mission m where m.consultant IS NULL and m.description like :y")
	public Page<Mission> rechercheMissionnonaffecte(@Param("y")String mc2,Pageable pageable);
//
}
