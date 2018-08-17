package tn.esprit.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.repository.TaskRepository;
import tn.esprit.spring.entity.Task;

@RestController
public class TestRestController {
    @Autowired
	private TaskRepository taskRepository;
    @GetMapping("/tasks")
    public List<Task> listTasks()
    {
    	
    	return taskRepository.findAll();
    }
    
    
    @PostMapping("/tasks")
    public Task save(@RequestBody Task t)
    {
		return taskRepository.save(t);
    	
    	
    }
    @RequestMapping(value="/tasks/",method=org.springframework.web.bind.annotation.RequestMethod.PUT)
    public Task update(@RequestBody Task t)
    {
   // t.setTaskName("semah");
		return taskRepository.save(t);
    	
    	
    }
    @RequestMapping(value="/tasks/{id}",method=org.springframework.web.bind.annotation.RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id)
    {
    	Task t=taskRepository.findOne(id);
	 taskRepository.delete(t);
		 return true;
    	
    }
}
