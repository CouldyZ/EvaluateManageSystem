package com.xt.dao;

import com.xt.bean.Admin;

public interface DaoAdmin {

	/*
	 * 判断验证管理员密码
	 */
	public boolean checkPwd(Admin admin);

	/*
	 * 添加管理员信息
	 */
	public boolean UpdateInfo(Admin admin);

	/*
	 * 修改管理员密码
	 */
	public boolean setPwd(Admin admin);

	/*
	 * 得到管理员所有的信息
	 */
	public Admin getAdmin();

}
