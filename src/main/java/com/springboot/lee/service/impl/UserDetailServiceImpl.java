package com.springboot.lee.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.lee.domain.LoginUser;
import com.springboot.lee.mapper.MenuMapper;
import com.springboot.lee.mapper.UserMapper;
import com.springboot.lee.pojo.User;

@Service
class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//查詢用戶訊息
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_name", username);
		queryWrapper.ne("status", 1);
		User user = userMapper.selectOne(queryWrapper);
		
		if(user == null) {
			throw new RuntimeException("can not searched any user role");
		}
		
		//查詢對應的權限信息
		List<String> list = new ArrayList<>(menuMapper.selectPermsByUserId(user.getId()));
		
		//把數據封裝成UserDetails返回
		return new LoginUser(user, list);
	}

}
