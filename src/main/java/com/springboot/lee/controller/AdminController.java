package com.springboot.lee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lee.constants.PermConstants;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserStatusDTO;
import com.springboot.lee.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@GetMapping("/userList")
	@PreAuthorize("hasAuthority('" + PermConstants.ADMIN + "')")
	public ResponseResult getBasicUserList() {
		return adminService.getBasicUserList();
	}
	
	@PutMapping("/userList")
	@PreAuthorize("hasAuthority('" + PermConstants.ADMIN + "')")
	public ResponseResult updateStatusOfUserList(@RequestBody List<UserStatusDTO> userStatusDTOList) {
		return adminService.updateStatusOfUserList(userStatusDTOList);
	}

}
