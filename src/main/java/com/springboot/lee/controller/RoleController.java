package com.springboot.lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/roleList")
	public ResponseResult getRoleList() {
		return roleService.getRoleList();
	}
}
