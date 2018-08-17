package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.File;

public interface FileRepository extends CrudRepository<File, Long>{

}
