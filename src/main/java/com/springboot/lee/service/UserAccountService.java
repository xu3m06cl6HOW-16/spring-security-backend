package com.springboot.lee.service;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserRoleDTO;

public interface UserAccountService {
	
	ResponseResult userUpdate(UserRoleDTO userRoleDTO);
}
