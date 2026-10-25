package com.springboot.lee.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springboot.lee.domain.LoginUser;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.mapper.UserMapper;

@Service("userNameVerificationImpl")
public class UserNameVerificationImpl extends UserBasicServiceImpl{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ResponseResult validateUser(String userInfo, String action) {
		Map<String,String> map = new HashMap<String,String>();
		Integer userExistsCount = 0 ;
		
		//已登錄,修改自己用戶名,不須判斷自己是否與自己重複用戶名
		if("update".equalsIgnoreCase(action)) {			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication != null) {
				if(authentication instanceof UsernamePasswordAuthenticationToken) {
					LoginUser loginUser = (LoginUser) authentication.getPrincipal();
					
					if(userInfo.equals(loginUser.getUsername())){
						return new ResponseResult(HttpStatus.OK.value(), "userNameAvailable.");
					}
				}
			}
		}
		
		userExistsCount = userMapper.checkUserName(userInfo);
		map.put("userExistsCount", String.valueOf(userExistsCount));
		
		if(userExistsCount == 0) {
			return new ResponseResult(HttpStatus.OK.value(), "userNameAvailable.", map);
		}else {			
			return new ResponseResult(HttpStatus.NOT_IMPLEMENTED.value(), "userNameUnavailable.", map);
		}
	}

}
