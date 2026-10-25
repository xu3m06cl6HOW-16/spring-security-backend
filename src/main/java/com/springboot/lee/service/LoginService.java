package com.springboot.lee.service;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.pojo.User;

public interface LoginService {

	ResponseResult login(User user);
	ResponseResult logout();

}
