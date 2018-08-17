package tn.esprit.spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.entity.User;

public interface ConsultantRepository extends CrudRepository<Consultant, Long>{
	@Query("select c from Consultant c where c.nomSociete like :x")
	public Page<Consultant> chercher(@Param("x")String mc,Pageable pageable);
	//public Consultant save(Consultant c);
	public Consultant findByUserName(String username);
	
	@Query("select c from Consultant c where c.userName= :x")
	public Consultant getConsultantbyLogin(@Param("x")String username);

	@Query("select c from Consultant c where c.nomSociete like :x and c.validation=true")
	public Page<Consultant> valide(@Param("x")String mc,Pageable pageable);

	@Query("select c from Consultant c where c.nomSociete like :x and c.validation=false")
	public Page<Consultant> nonvalide(@Param("x")String mc,Pageable pageable);

}
