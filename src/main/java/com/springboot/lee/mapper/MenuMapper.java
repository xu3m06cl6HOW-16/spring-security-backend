package com.springboot.lee.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.lee.pojo.Menu;

public interface MenuMapper extends BaseMapper<Menu>{
	
	List<String> selectPermsByUserId(Long userid);

}
