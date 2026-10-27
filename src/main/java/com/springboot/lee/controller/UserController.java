package com.springboot.lee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lee.constants.PermConstants;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserRoleDTO;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.UserAccountService;
import com.springboot.lee.service.UserBasicService;
import com.springboot.lee.service.impl.UserBasicServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userBasicServiceDefaultImpl")
	private UserBasicService userBasicService;

	@Autowired
	@Qualifier("userNameVerificationImpl")
	private UserBasicServiceImpl nameVerificationService;

	@Autowired
	@Qualifier("userEmailVerificationImpl")
	private UserBasicServiceImpl emailVerificationService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping("/validateUserName/{userName}/{action}")
	public ResponseResult validateUserName(@PathVariable String userName, @PathVariable("action") String action) {
		return nameVerificationService.validateUser(userName, action);
	}
	
	@GetMapping("/validateEmail/{userEmail}/{action}")
	public ResponseResult validateUserEmail(@PathVariable String userEmail, @PathVariable("action") String action) {
		return emailVerificationService.validateUser(userEmail, action);
	}
	
	@GetMapping("/basic")
	public ResponseResult getUserBySecurityContextHolder() {
		
		return userBasicService.getUserBySecurityContextHolder();
	}
	
	@PostMapping("/basic")
	public ResponseResult userRegister(@Valid @RequestBody User user) {
		
		return userBasicService.userRegister(user);
	}
	
	@PutMapping("/basic")
	@PreAuthorize("hasAuthority('" + PermConstants.VIP1 + "')")
	public ResponseResult userUpdate(@RequestBody @Valid UserRoleDTO userRoleDTO) {
		
		return userAccountService.userUpdate(userRoleDTO);
	}
	

}
