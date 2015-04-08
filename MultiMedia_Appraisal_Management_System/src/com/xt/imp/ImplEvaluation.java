package com.xt.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xt.bean.Evaluation;
import com.xt.dao.DaoEvaluation;
import com.xt.utils.UtilDB;

public class ImplEvaluation implements DaoEvaluation {
	/*
	 * 增加评价
	 */
	public boolean addEvaluation(Evaluation evaluation) {
		boolean flag = false;
		String sql = "insert into evaluate(eva_name,eva_score,eva_content,eva_date) "
				+ "values('"
				+ evaluation.getEva_name()
				+ "','"
				+ evaluation.getEva_score()
				+ "','"
				+ evaluation.getEva_content()
				+ "','"
				+ evaluation.getEva_date() + "')";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.execute(sql);
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
	 * 更新评价
	 */
	public boolean updateEvaluation(Evaluation evaluation) {
		boolean flag = false;
		String sql1 = "update evaluate set eva_score ='"
				+ evaluation.getEva_score() + "'  where eva_name='"
				+ evaluation.getEva_name() + "'";

		String sql2 = "update evaluate set eva_content ='"
				+ evaluation.getEva_content() + "'  where eva_name='"
				+ evaluation.getEva_name() + "'";

		String sql3 = "update evaluate set eva_date ='"
				+ evaluation.getEva_date() + "'  where eva_name='"
				+ evaluation.getEva_name() + "'";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.execute(sql1);
			sta.execute(sql2);
			sta.execute(sql3);
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
	 * 查询所有用户
	 * 
	 * 成功则返回一个用户列表
	 */
	public List<Evaluation> queryAll() {

		List<Evaluation> list = new ArrayList<Evaluation>();

		String sql = "select * from evaluate";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		ResultSet rs = UtilDB.getRes(sta, sql);
		try {
			while (rs.next()) {
				Evaluation eva = new Evaluation(rs.getString("eva_name"),
						rs.getString("eva_score"), rs.getString("eva_content"),
						rs.getString("eva_date"));
				list.add(eva);
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
		return list;

	}

	/*
	 * 查询所有用户
	 * 
	 * 成功则返回一个用户列表
	 */
	public Evaluation queryOne(String username) {

		String sql = "select * from evaluate where eva_name = '" + username
				+ "'";
		Evaluation eva = null;
		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		ResultSet rs = UtilDB.getRes(sta, sql);
		try {
			while (rs.next()) {
				eva = new Evaluation(rs.getString("eva_name"),
						rs.getString("eva_score"), rs.getString("eva_content"),
						rs.getString("eva_date"));
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
		return eva;

	}

	public boolean deleteEvaluationByName(String name) {

		boolean flag = false;

		String sql = "delete from evaluate where eva_name='" + name + "'";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.execute(sql);
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

}
