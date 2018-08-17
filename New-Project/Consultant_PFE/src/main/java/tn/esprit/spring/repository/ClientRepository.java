package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ChargeDeCompte;
import tn.esprit.spring.entity.Client;


public interface ClientRepository extends CrudRepository<Client, Long>{
	@Query("select c from Client c where c.userName= :x")
	public Client getClientByUserName(@Param("x")String username);
}
