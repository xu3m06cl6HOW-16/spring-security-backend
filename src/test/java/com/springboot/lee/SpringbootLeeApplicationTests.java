package com.springboot.lee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.lee.mapper.MenuMapper;
import com.springboot.lee.mapper.UserMapper;


@SpringBootTest
class SpringbootLeeApplicationTests {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;

	@Test
	void contextLoads() {
		System.out.println(menuMapper.selectPermsByUserId(2L));
	}

}
