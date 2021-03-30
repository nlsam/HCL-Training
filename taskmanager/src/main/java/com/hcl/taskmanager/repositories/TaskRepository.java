package com.hcl.taskmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.taskmanager.entities.Task;

public interface TaskRepository extends CrudRepository <Task, Integer>{

}
