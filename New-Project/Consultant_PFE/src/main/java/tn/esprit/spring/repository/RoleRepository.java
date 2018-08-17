package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Role;


public interface RoleRepository extends CrudRepository<Role,Long> {
	public Role findByRoleName(String roleName);

}
