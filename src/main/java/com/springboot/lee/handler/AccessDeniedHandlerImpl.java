package com.springboot.lee.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.utils.WebUtils;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		ResponseResult responseResult = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您的權限不足");
		String result = JSONObject.toJSONString(responseResult);
		// 處理異常
		WebUtils.renderString(response, result);
		
	}

}
