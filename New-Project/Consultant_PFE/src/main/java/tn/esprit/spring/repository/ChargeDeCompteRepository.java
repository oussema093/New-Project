package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ChargeDeCompte;

public interface ChargeDeCompteRepository extends CrudRepository<ChargeDeCompte, Long>{

	@Query("select cc from ChargeDeCompte cc where cc.userName= :x")
	public ChargeDeCompte getChargeDeCompte(@Param("x")String username);
}
