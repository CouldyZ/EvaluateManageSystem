package com.xt.dao;

import com.xt.bean.Admin;

public interface DaoAdmin {

	/*
	 * �ж���֤����Ա����
	 */
	public boolean checkPwd(Admin admin);

	/*
	 * ��ӹ���Ա��Ϣ
	 */
	public boolean UpdateInfo(Admin admin);

	/*
	 * �޸Ĺ���Ա����
	 */
	public boolean setPwd(Admin admin);

	/*
	 * �õ�����Ա���е���Ϣ
	 */
	public Admin getAdmin();

}
