package com.springboot.lee.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.springboot.lee.pojo.Role;
import com.springboot.lee.pojo.User;

public class UserRoleDTO {
	
	@Valid
    @NotNull(message = "用戶資料不能為空")
	private User user;
	
	private Set<Role> roleSet;

	public UserRoleDTO() {
		super();
	}

	public UserRoleDTO(User user, Set<Role> roleSet) {
		super();
		this.user = user;
		this.roleSet = roleSet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	@Override
	public String toString() {
		return "UserRoleDTO [user=" + user + ", roleSet=" + roleSet + "]";
	}

}
