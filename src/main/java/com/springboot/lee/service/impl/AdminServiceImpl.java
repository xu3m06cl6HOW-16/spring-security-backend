package com.springboot.lee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserStatusDTO;
import com.springboot.lee.mapper.UserMapper;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public ResponseResult getBasicUserList() {
		Map<String,List<User>> map = new HashMap<String,List<User>>();
		List<User> userList = userMapper.getBasicUserList();
		map.put("userList", userList);
		return new ResponseResult(HttpStatus.OK.value(), "getBasicUserList", map);
	}

	@Override
	@Transactional
	public ResponseResult updateStatusOfUserList(List<UserStatusDTO> userStatusDTOList) {
		
		for(UserStatusDTO userStatusDTO : userStatusDTOList) {
			
			UpdateWrapper<User> userWrapper = new UpdateWrapper<>();
			userWrapper.eq("id", userStatusDTO.getId()).set("status", userStatusDTO.getStatus());
			
			 userMapper.update(null, userWrapper);
		}
		
		return new ResponseResult(HttpStatus.OK.value(),"updateStatusOfUserList");
	}

}
