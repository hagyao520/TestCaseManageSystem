package com.xiaoju.framework.entity.request.auth;

import lombok.Data;

/**
 * Created by 刘智 on 2021/4/22.
 */
@Data
public class UserRegisterReq {
	private String username;

	private String password;

	private String newpassword;

	private boolean isLogin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}
