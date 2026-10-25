package com.springboot.lee.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

@TableName(value="sys_role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role implements Serializable{
	
	private static final long serialVersionUID = 9110787099833283548L;
	
	@TableId
	private Long id;
	/**
	 * 角色名稱
	 */
	private String name;
	/**
	 * 角色權限字符串
	 */
	private String roleKey;
	/**
	 * 角色狀愛（0正常 1停用）
	 */
	private String status;
	/**
	 *  刪除標誌（0代表未刪除，1代表已刪除）
	 */
	private Integer delFlag;
	/**
	 * 創建人的用戶id
	 */
	private Long createBy;
	/**
	 * 創建時間
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private Long updateBy;
	/**
	 * 更新時間
	 */
	private Date updateTime;
	/**
	 * 備註
	 */
	private String remark;
	
	public Role() {
		super();
	}
	public Role(Long id, String name, String roleKey, String status, Integer delFlag, Long createBy, Date createTime,
			Long updateBy, Date updateTime, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.roleKey = roleKey;
		this.status = status;
		this.delFlag = delFlag;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.remark = remark;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", roleKey=" + roleKey + ", status=" + status + ", delFlag="
				+ delFlag + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy=" + updateBy
				+ ", updateTime=" + updateTime + ", remark=" + remark + "]";
	}
	
}
