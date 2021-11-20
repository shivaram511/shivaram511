package com.tech.model;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO implements Serializable {
	


	@NotEmpty
	@NotNull
	private Integer userId;
	
	@NotEmpty
	@NotNull
	private Integer mobileNo;

	public Integer getUserId() {
		return userId;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
