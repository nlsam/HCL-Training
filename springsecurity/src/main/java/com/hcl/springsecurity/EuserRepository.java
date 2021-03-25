package com.hcl.springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.springsecurity.models.Euser;

import java.util.Optional;

public interface EuserRepository extends JpaRepository<Euser, Integer>{
	  Optional <Euser> findByUsername(String username);
}
