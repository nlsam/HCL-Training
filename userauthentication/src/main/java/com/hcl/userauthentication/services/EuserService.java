package com.hcl.userauthentication.services;

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

import com.hcl.userauthentication.entities.Euser;
import com.hcl.userauthentication.exceptions.UserNotFoundException;
import com.hcl.userauthentication.repositories.EuserRepository;

@Service
public class EuserService {
	

	@Autowired
	private EuserRepository euserRepository;
	
    @Autowired
	private EntityManager em;
	 
	
	public List<Euser> userSearch(String username, String password) {
		
		CriteriaBuilder finding= em.getCriteriaBuilder();
		CriteriaQuery<Euser>  result= finding.createQuery(Euser.class);
		
	    Root<Euser> userSet= result.from(Euser.class);
		Predicate usernamePredicate= finding.equal(userSet.get("username"), username);
		Predicate passwordPredicate= finding.equal(userSet.get("password"), password);
		result.where(usernamePredicate,passwordPredicate);
		
		TypedQuery<Euser> query = em.createQuery(result);
		return query.getResultList();
		
	}
	
	
	public String loginUser(String username, String password) {
		List<Euser> result = userSearch(username,password);
		String message=null;
		if (result.size()!=0) {
			for (Euser p: result) {
				message= p.getName(); 
			}
		}
		else {
			throw new UserNotFoundException();
		}
		return message;
	}
	
	
	 public void saveUser(Euser newuser) {
	    	euserRepository.save(newuser);
	    }
	
	
	

}
