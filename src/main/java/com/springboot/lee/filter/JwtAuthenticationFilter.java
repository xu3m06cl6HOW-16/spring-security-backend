package com.springboot.lee.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.lee.domain.LoginUser;
import com.springboot.lee.utils.JwtUtil;
import com.springboot.lee.utils.RedisCache;

import io.jsonwebtoken.Claims;
import io.netty.util.internal.StringUtil;
/**
 * OncePerRequestFilter可保證請求只經過濾器一次
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	RedisCache redisCache;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//獲取token
		String token = request.getHeader("token");
		String userid = "";
		
		if(StringUtil.isNullOrEmpty(token)) {
			//放行
			filterChain.doFilter(request, response);
			return;
		}
		//解析token
		try {
			Claims claims = JwtUtil.parseJWT(token);
			userid = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Token analyze failed");
		}
		//從redis獲取用戶信息
		String redisKey = "login:" + userid;
		LoginUser loginUser =  redisCache.getCacheObject(redisKey);
		
		if(loginUser == null) {
			throw new RuntimeException("redisCacheGetLoginUser is failed");
		}
		//TODO 需再檢查資料庫user的status
		//存入securityContext提供給後面filter鍊檢驗用	
		//獲取權限信息getAuthorities()到Authentication
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		filterChain.doFilter(request, response);
	}

}
