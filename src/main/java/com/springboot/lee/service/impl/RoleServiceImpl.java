package com.springboot.lee.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.mapper.RoleMapper;
import com.springboot.lee.pojo.Role;
import com.springboot.lee.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public ResponseResult getRoleList() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Role> roleList = roleMapper.selectList(null);
		Set<Role> roleSet = new HashSet<>(roleList);
		map.put("roleSet", roleSet);
		System.out.println(roleSet);
		return new ResponseResult(HttpStatus.OK.value(), "getRoleSet", map);
	}

}
