package com.springboot.lee.service;

import java.util.List;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserStatusDTO;

public interface AdminService {
	
	ResponseResult getBasicUserList();
	
	ResponseResult updateStatusOfUserList(List<UserStatusDTO> userStatusDTOList);

}
