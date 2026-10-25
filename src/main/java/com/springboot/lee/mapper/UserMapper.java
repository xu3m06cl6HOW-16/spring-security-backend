package com.springboot.lee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.lee.pojo.User;


public interface UserMapper extends BaseMapper<User>{
	
	Integer userRegister(User user);
	
	Integer checkUserName(String userName);
	
	Integer checkUserEmail(String email);
	
	Integer insertUserRoleByUserId(@Param("userId") Long userId, @Param("roleId") Integer roleId);

	Integer userUpdate(User user);
	
	List<User> getBasicUserList();
}
