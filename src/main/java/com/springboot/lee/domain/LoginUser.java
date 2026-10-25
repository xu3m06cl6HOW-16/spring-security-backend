package com.springboot.lee.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.annotation.JSONField;
import com.springboot.lee.pojo.User;

public class LoginUser implements UserDetails{
	
	private User user;
	
	private List<String> permissions;
	
	@JSONField(serialize = false)
	private Set<GrantedAuthority> authorities;

	public LoginUser() {
		super();
	}

	public LoginUser(User user) {
		super();
		this.user = user;
	}
	
	public LoginUser(User user, List<String> permissions) {
		super();
		this.user = user;
		this.permissions = permissions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "LoginUser [user=" + user + "]";
	}
	
	@Override //springSecurity實際調用權限信息的方法
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if(authorities != null) {
			return authorities;
		}
		authorities = new HashSet<GrantedAuthority>();
		//把permission中的String類型的權限信息封裝成SimpleGrantedAuthority對象
		for(String permission : permissions) {
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
			authorities.add(simpleGrantedAuthority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
