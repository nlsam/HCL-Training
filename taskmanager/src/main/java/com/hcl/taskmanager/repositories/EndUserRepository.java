package com.hcl.taskmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.taskmanager.entities.EndUser;

public interface EndUserRepository extends CrudRepository <EndUser, Integer>{

}
