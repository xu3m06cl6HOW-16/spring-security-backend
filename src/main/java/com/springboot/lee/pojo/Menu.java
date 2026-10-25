package com.springboot.lee.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@TableName(value="sys_menu")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
	
    private static final long serialVersionUID = -54979041104113736L;

    @TableId
    private Long id;
    /**
    * 權限名
    */
    private String menuName;
    /**
    * 路由位址
    */
    private String path;
    /**
    * 元件路徑
    */
    private String component;
    /**
    * 選單狀態（0顯示 1隱藏）
    */
    private String visible;
    /**
    * 選單狀態（0正常 1停用）
    */
    private String status;
    /**
    * 權限標識
    */
    private String perms;
    /**
    * 權限圖示
    */
    private String icon;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    
    private Integer delFlag;
    
    private String remark;

	public Menu() {
		super();
	}

	public Menu(Long id, String menuName, String path, String component, String visible, String status, String perms,
			String icon, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer delFlag,
			String remark) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.path = path;
		this.component = component;
		this.visible = visible;
		this.status = status;
		this.perms = perms;
		this.icon = icon;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.delFlag = delFlag;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", path=" + path + ", component=" + component
				+ ", visible=" + visible + ", status=" + status + ", perms=" + perms + ", icon=" + icon + ", createBy="
				+ createBy + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime
				+ ", delFlag=" + delFlag + ", remark=" + remark + "]";
	}
   
}
