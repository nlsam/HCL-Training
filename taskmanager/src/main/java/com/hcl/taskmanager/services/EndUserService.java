package com.hcl.taskmanager.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hcl.taskmanager.entities.EndUser;
import com.hcl.taskmanager.exceptions.UserNotFoundException;
import com.hcl.taskmanager.repositories.EndUserRepository;

@Service
public class EndUserService {

	@Autowired
	private EndUserRepository endUserRepository;

    @Autowired
	private EntityManager em;
    
	public List<EndUser> userSearch(String username, String password) {
		
		CriteriaBuilder finding= em.getCriteriaBuilder();
		CriteriaQuery<EndUser>  result= finding.createQuery(EndUser.class);
		
	    Root<EndUser> userSet= result.from(EndUser.class);
		Predicate usernamePredicate= finding.equal(userSet.get("username"), username);
		Predicate passwordPredicate= finding.equal(userSet.get("password"), password);
		result.where(usernamePredicate,passwordPredicate);
		
		TypedQuery<EndUser> query = em.createQuery(result);
		return query.getResultList();
		
	}
	
	
	public List<EndUser> searchByEmail(String email) {
		CriteriaBuilder finding= em.getCriteriaBuilder();
		CriteriaQuery<EndUser>  result= finding.createQuery(EndUser.class);
		
	    Root<EndUser> userSet= result.from(EndUser.class);
		Predicate emailPredicate= finding.equal(userSet.get("email"), email);
		result.where(emailPredicate);
		
		TypedQuery<EndUser> query = em.createQuery(result);
		return query.getResultList();
	}
	
	
	 public void saveUser(EndUser newuser) {
	    	endUserRepository.save(newuser);
	    }
}
