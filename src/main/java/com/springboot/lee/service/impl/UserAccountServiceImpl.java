package com.springboot.lee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.dto.UserRoleDTO;
import com.springboot.lee.mapper.UserMapper;
import com.springboot.lee.mapper.UserRoleMapper;
import com.springboot.lee.pojo.Role;
import com.springboot.lee.pojo.UserRole;
import com.springboot.lee.service.UserAccountService;
import com.springboot.lee.service.UserValidationService;
import com.springboot.lee.utils.RedisCache;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private RedisCache redisCache;
	
	@Autowired
	private UserValidationService userValidationService;

	@Transactional
	public ResponseResult userUpdate(UserRoleDTO userRoleDTO) {
		
		boolean basicRole = false;
		String errorMsg = "儲存失敗";
		
		for(Role role : userRoleDTO.getRoleSet()) {
			if("vip1".equalsIgnoreCase(role.getRoleKey())) {
				basicRole = true;
			}else {
				errorMsg = "本不可沒有基本用戶權限";
			}
		}
		if(basicRole) {			
			ResponseResult responseResult = userValidationService.validateUserName(
				    userRoleDTO.getUser().getUserName(), "update"
				);

				if (HttpStatus.OK.value() != responseResult.getCode()) {
				    basicRole = false;
				    errorMsg = "用戶名重複";
				}else {
					
					responseResult = userValidationService.validateEmail(
							userRoleDTO.getUser().getEmail(), "update"
							);
					
					if (HttpStatus.OK.value() != responseResult.getCode()) {
						basicRole = false;
						errorMsg = "信箱已被使用";
					}
					
				}

		}
		
		if(basicRole) {
			
			QueryWrapper<UserRole> userRoleWrapper = new QueryWrapper<>();
			Long userid = userRoleDTO.getUser().getId();
			
			userMapper.userUpdate(userRoleDTO.getUser());// 修改User資料
			
			userRoleWrapper.eq("user_id", userid);
			userRoleMapper.delete(userRoleWrapper);// 刪除user_role資料
			
			for(Role role : userRoleDTO.getRoleSet()) {
				userRoleMapper.insert(new UserRole(userid, role.getId()));// 塞入新user_role資料
			}
			redisCache.deleteObject("login:" + userid);// 更新完成會退出登陸,所以我們刪除redis緩存資料,等同登出
			
			return new ResponseResult(HttpStatus.OK.value(), "userUpdateSuccessed");
			
		}else {
			return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg);						
		}
		
	}

}
