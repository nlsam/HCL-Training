package com.hcl.userinfo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.userinfo.entity.UserInfo;
import com.hcl.userinfo.exceptions.UserNotFoundException;
import com.hcl.userinfo.repository.UserInfoRepository;

@Service
public class UserInfoService {
	

	@Autowired
	 private UserInfoRepository userInfoRepository;
	
	

    public Iterable<UserInfo> GetAllUsers()
    {
        return userInfoRepository.findAll();
    }


    public UserInfo GetUserByName(String name) {
        UserInfo foundUser = userInfoRepository.findByName(name);
        return foundUser;
    }
    
    public UserInfo GetUserById(int id) {
    	Optional<UserInfo> foundUser = userInfoRepository.findById(id);
    	
    	    	    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(UserInfo usertoUpdate) {
    	userInfoRepository.save(usertoUpdate);
    }

}
