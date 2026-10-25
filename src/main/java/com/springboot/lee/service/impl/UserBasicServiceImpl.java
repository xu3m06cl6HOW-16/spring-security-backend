package com.springboot.lee.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.lee.domain.LoginUser;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserRoleDTO;
import com.springboot.lee.mapper.RoleMapper;
import com.springboot.lee.mapper.UserMapper;
import com.springboot.lee.pojo.Role;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.UserBasicService;

public abstract class UserBasicServiceImpl implements UserBasicService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public ResponseResult userRegister(User user) {
		
		if(userMapper.checkUserName(user.getUserName()) == 0 && userMapper.checkUserEmail(user.getEmail()) == 0) {
			
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setUserType("1");
			user.setDelFlag(0);
			
			Integer userRegisterCount = userMapper.userRegister(user);
			//給基本的使用者角色
			Integer userRoleCount = userMapper.insertUserRoleByUserId(user.getId(), 2);
			
			if(userRegisterCount > 0 && userRoleCount > 0) {			
				return new ResponseResult(HttpStatus.OK.value(), "用戶 : " + user.getId() + "創建成功.", user);
			}else {
				throw new RuntimeException("用戶或角色新增失敗");
			}
		}else {
			throw new RuntimeException("用戶名重複");
		}

	}

	@Override //驗證方式各自實作
	public abstract ResponseResult validateUser(String userInfo, String action);

	@Override
	public ResponseResult getUserBySecurityContextHolder() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Set<Role> roleSet = new HashSet<Role>();
		
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		Long userid = loginUser.getUser().getId();
		
		roleSet = roleMapper.getRoleByUserId(userid);
		
		UserRoleDTO userRoleDTO = new UserRoleDTO(loginUser.getUser(), roleSet);
		
		map.put("userRoleDTO", userRoleDTO);
		
		return new ResponseResult(HttpStatus.OK.value(), "getUserBySecurityContextHolder", map);
	}

}
