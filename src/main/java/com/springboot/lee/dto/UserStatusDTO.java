package com.springboot.lee.dto;

public class UserStatusDTO {

	private Long id;
	
	private String status;

	public UserStatusDTO() {
		super();
	}

	public UserStatusDTO(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserStatusDTO [id=" + id + ", status=" + status + "]";
	}
	
}
