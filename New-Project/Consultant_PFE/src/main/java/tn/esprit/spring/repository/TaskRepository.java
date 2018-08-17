package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
