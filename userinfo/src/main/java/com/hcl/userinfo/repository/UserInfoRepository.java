package com.hcl.userinfo.repository;

import org.springframework.data.repository.CrudRepository;


import com.hcl.userinfo.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository <UserInfo, Integer> {
	public UserInfo findByName(String name);


}
