package com.springboot.lee.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.lee.pojo.Role;

public interface RoleMapper extends BaseMapper<Role>{
	
	Set<Role> getRoleByUserId(@Param("userId") Long userId);

}
