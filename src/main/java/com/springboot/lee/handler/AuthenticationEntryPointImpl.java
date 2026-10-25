package com.springboot.lee.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.utils.WebUtils;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "認證失敗請重新登錄");
		String result = JSONObject.toJSONString(responseResult);
		// 處理異常
		WebUtils.renderString(response, result);
	}

}
