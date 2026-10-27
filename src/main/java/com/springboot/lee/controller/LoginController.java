package com.springboot.lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseResult login(@RequestBody User user) {
		return loginService.login(user);
	}
	
	@GetMapping("/logout")
	public ResponseResult logout() {
		return loginService.logout();
	}
	
}
