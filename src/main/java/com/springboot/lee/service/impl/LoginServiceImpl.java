package com.springboot.lee.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springboot.lee.domain.LoginUser;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.LoginService;
import com.springboot.lee.utils.JwtUtil;
import com.springboot.lee.utils.RedisCache;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private RedisCache redisCache;

	@Override
	public ResponseResult login(User user) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		//AuthenticationManager authenticate進行用戶認證
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
		//authenticate會調用到UserDetail裡面的loadUserByUserNames()去校驗
		
		try{			
			Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
			//通過了使用userId,生成一個jwt, jwt存入ResponseResult作為返回
			LoginUser loginUser = (LoginUser)authentication.getPrincipal();
			String userId = loginUser.getUser().getId().toString();
			String Jwt = JwtUtil.createJWT(userId);
			map.put("token", Jwt);	
			//完整的用戶信息存入redis userId作為key
			redisCache.setCacheObject("login:" + userId , loginUser);
			
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Login Failed");
		}
		

		
		return new ResponseResult(200, "loginSuccess.", map);
	}

	@Override
	public ResponseResult logout() {
		
		//獲取SecurityContextHolder中的用戶id
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		
		Long userid = loginUser.getUser().getId();
		//刪除redis中的值
		redisCache.deleteObject("login:" + userid);
		
		return new ResponseResult(200, "logout success.");
	}

}
