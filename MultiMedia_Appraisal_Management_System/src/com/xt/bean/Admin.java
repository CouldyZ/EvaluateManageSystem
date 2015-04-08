package com.xt.bean;

/*
 * 管理员
 * */
public class Admin {

	// 管理员用户名
	private String username;
	// 管理员密码
	private String password;
	// 管理员个人信息
	private String info;

	public Admin(String username, String password) {
        this(username,password);
	}

	public Admin(String username, String password, String info) {
		this.username = username;
		this.password = password;
		this.info = info;
	}

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
