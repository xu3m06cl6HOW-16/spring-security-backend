package com.springboot.lee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
	
	Integer updateStatusOfUserList(@Param("useridList")List<Long> useridList, 
								   @Param("status") String status);


}
