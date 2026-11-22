package com.springboot.lee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.lee.constants.UserStatus;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserStatusDTO;
import com.springboot.lee.mapper.AdminMapper;
import com.springboot.lee.mapper.UserMapper;
import com.springboot.lee.pojo.User;
import com.springboot.lee.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AdminMapper adminMapper;
	
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
		
		ArrayList<Long> disabledUsers = new ArrayList<Long>();
		ArrayList<Long> normalUsers = new ArrayList<Long>();
		
		for(UserStatusDTO userStatusDTO : userStatusDTOList) { //收集停用與啟用用戶
			if("1".equals(userStatusDTO.getStatus())) {
				disabledUsers.add(userStatusDTO.getId());
			}else {
				normalUsers.add(userStatusDTO.getId());
			}
		}
		if(disabledUsers.size() > 0 ){			
			adminMapper.updateStatusOfUserList(disabledUsers, UserStatus.DISABLED.getCode());
		}
		if(normalUsers.size() > 0 ){			
			adminMapper.updateStatusOfUserList(normalUsers, UserStatus.NORMAL.getCode());
		}
		
		return new ResponseResult(HttpStatus.OK.value(),"updateStatusOfUserList");
	}

}
