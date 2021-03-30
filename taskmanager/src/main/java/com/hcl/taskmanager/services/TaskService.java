package com.hcl.taskmanager.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.taskmanager.entities.EndUser;
import com.hcl.taskmanager.entities.Task;
import com.hcl.taskmanager.repositories.TaskRepository;

@Service 
public class TaskService {
 
	@Autowired 
	private TaskRepository taskRepository;
	

	public void saveTask(Task newTask) {
	    	taskRepository.save(newTask);
	    }
	public void deleteTask(Task newTask) {
    	taskRepository.delete(newTask);
    }
	
	public Iterable<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task getTaskbyId(int id) {
		Optional<Task> foundTask=taskRepository.findById(id);
		return(foundTask.get());
	}
	
	
	
}
