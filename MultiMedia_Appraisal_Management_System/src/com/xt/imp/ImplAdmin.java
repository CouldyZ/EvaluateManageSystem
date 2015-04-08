package com.xt.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xt.bean.Admin;
import com.xt.dao.DaoAdmin;
import com.xt.utils.UtilDB;

public class ImplAdmin implements DaoAdmin {

	/**
	 * �жϹ���Ա�����Ƿ���ȷ
	 */
	public boolean checkPwd(Admin admin) {
		boolean flag = false;
		Admin admin1 = getAdmin();
		if (admin1 != null) {
			flag = admin1.getPassword().equals(admin.getPassword());
		}
		return flag;
	}

	/*
	 * ���¹���Ա������Ϣ
	 */
	public boolean UpdateInfo(Admin admin) {

		boolean flag = false;
		String sql = "update admin set adm_info ='" + admin.getInfo()
				+ "' where adm_username='" + admin.getUsername() + "'";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.executeUpdate(sql);
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				UtilDB.closeConn(conn);
			}
		}
		return flag;
	}

	/*
	 * �޸Ĺ���Ա����
	 */
	public boolean setPwd(Admin admin) {

		boolean flag = false;
		String sql = "update admin set adm_password ='" + admin.getPassword()
				+ "' where adm_username='" + admin.getUsername() + "'";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.executeUpdate(sql);
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				UtilDB.closeConn(conn);
			}
		}
		return flag;
	}

	/**
	 * �õ�һ������Ա������
	 */
	public Admin getAdmin() {

		Admin admin = null;
		String sql = "select * from admin";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		ResultSet rs = UtilDB.getRes(sta, sql);
		try {
			while (rs.next()) {
				admin = new Admin(rs.getString("adm_username"),
						rs.getString("adm_password"), rs.getString("adm_info"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (!(rs == null)) {
					try {
						sta.close();
					} catch (SQLException e) {

						e.printStackTrace();
					} finally {
						if (!(sta == null)) {
							UtilDB.closeConn(conn);
						}
					}
				}
			}
		}
		return admin;
	}
}
