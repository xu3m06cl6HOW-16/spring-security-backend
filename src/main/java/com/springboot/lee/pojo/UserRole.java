package com.springboot.lee.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

@TableName(value="sys_user_role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = 8296621380662125409L;
	
	/**
	 * 用戶id
	 */
	private Long userId;
	/**
	 * 角色id
	 */
	private Long roleId;
	
	public UserRole() {
		super();
	}

	public UserRole(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}

}
