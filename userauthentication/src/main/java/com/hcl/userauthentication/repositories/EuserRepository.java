package com.hcl.userauthentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.userauthentication.entities.Euser;

public interface EuserRepository extends CrudRepository <Euser, Integer>{

}
