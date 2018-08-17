package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long TaskId;
	private String TaskName;
	public Task(Long  taskId, String taskName) {
		this.TaskId = taskId;
		this.TaskName = taskName;
	}
	public Task(String taskName) {
		super();
		this.TaskName = taskName;
	}
	public Task() {
		super();
	}
	public Long getTaskId() {
		return TaskId;
	}
	public void setTaskId(Long taskId) {
		this.TaskId = taskId;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		this.TaskName = taskName;
	}
	

}