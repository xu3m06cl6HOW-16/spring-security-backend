package com.springboot.lee.service;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserRoleDTO;
import com.springboot.lee.pojo.User;

public interface UserBasicService {
	
	ResponseResult userRegister(User user);
	
	ResponseResult getUserBySecurityContextHolder();
	
	ResponseResult validateUser(String userInfo, String action);

}
