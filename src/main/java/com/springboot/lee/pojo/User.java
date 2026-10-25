package com.springboot.lee.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * 用戶表(User)POJO
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    /**
    * 主鍵
    */
    @TableId
    private Long id;
    /**
    * 用户名
    */
    @NotBlank(message = "用戶名不能為空")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "用戶名只能包含英文和數字")
    private String userName;
    /**
    * 暱稱
    */
    @NotBlank(message = "暱稱不能為空")
    private String nickName;
    /**
    * 密碼
    */
    @NotBlank(message = "密碼不能為空")
    private String password;
    /**
    * 帳號狀態（0正常 1停用）
    */
    private String status;
    /**
    * 信箱
    */
    @Email(message = "Email 格式錯誤")
    private String email;
    /**
    * 手機
    */
    @NotBlank(message = "手機號碼不能為空")
    @Pattern(regexp = "^09\\d{8}$", message = "手機號碼必須為09開頭的10位數字")
    private String phonenumber;
    /**
    * 用戶性別（0男，1女，2未知）
    */
    private String sex;
    /**
    * 頭像
    */
    private String avatar;
    /**
    * 用戶類型（0管理員，1普通用戶）
    */
    private String userType;
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
    * 刪除標誌（0代表未刪除，1代表已刪除）
    */
    private Integer delFlag;
    
	public User() {
		super();
	}

	public User(Long id, String userName, String nickName, String password, String status, String email,
			String phonenumber, String sex, String avatar, String userType, Long createBy, Date createTime,
			Long updateBy, Date updateTime, Integer delFlag) {
		super();
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.status = status;
		this.email = email;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.avatar = avatar;
		this.userType = userType;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.delFlag = delFlag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nickName=" + nickName + ", password=" + password
				+ ", status=" + status + ", email=" + email + ", phonenumber=" + phonenumber + ", sex=" + sex
				+ ", avatar=" + avatar + ", userType=" + userType + ", createBy=" + createBy + ", createTime="
				+ createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", delFlag=" + delFlag + "]";
	}
}