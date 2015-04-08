package com.xt.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xt.bean.Student;
import com.xt.dao.DaoStudent;
import com.xt.utils.UtilDB;

public class ImplStudent implements DaoStudent {

	/*
	 * 增加学生账号
	 */
	public boolean addStudent(Student student) {
		boolean flag = false;
		String sql = "insert into student(stu_username,stu_password,stu_name,stu_sex,stu_class) "
				+ "values('"
				+ student.getStu_username()
				+ "','"
				+ student.getStu_password()
				+ "','"
				+ student.getStu_name()
				+ "','"
				+ student.getStu_sex()
				+ "','"
				+ student.getStu_class()
				+ "')";

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
	 * 修改学生个人信息
	 */
	public boolean updateStudent(Student student) {

		boolean flag = false;
		String sql1 = "update student set stu_name ='" + student.getStu_name()
				+ "' where stu_username='" + student.getStu_username() + "'";
		String sql2 = "update student set stu_sex ='" + student.getStu_sex()
				+ "' where stu_username='" + student.getStu_username() + "'";
		String sql3 = "update student set stu_class ='"
				+ student.getStu_class() + "' where stu_username='"
				+ student.getStu_username() + "'";
		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		try {
			sta.executeUpdate(sql1);
			sta.executeUpdate(sql2);
			sta.executeUpdate(sql3);
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
	 * 修改密码
	 */
	public boolean updateStudentPwd(Student student) {

		boolean flag = false;

		String sql = "update student set stu_password='"
				+ student.getStu_password() + " ' where stu_username='"
				+ student.getStu_username() + "'";

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
	 * 根据用户名 删除 学生 记录
	 */
	public boolean deleteStudentByName(String num) {

		boolean flag = false;

		String sql = "delete from student where stu_username='" + num + "'";

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
	 * 查询所有学生信息
	 * 
	 * 成功则返回一个学生列表
	 */
	public List<Student> queryAll() {

		List<Student> list = new ArrayList<Student>();

		String sql = "select * from student";

		Connection conn = UtilDB.getConn();

		Statement sta = UtilDB.getSta(conn);

		ResultSet rs = UtilDB.getRes(sta, sql);
		try {
			while (rs.next()) {
				Student stu = new Student(rs.getString("stu_username"),
						rs.getString("stu_password"), rs.getString("stu_name"),
						rs.getString("stu_sex"), rs.getString("stu_class"));
				list.add(stu);
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
	 * 查询所有学生信息
	 * 
	 * 成功则返回一个学生列表
	 */
	public Student queryOne(String username) {

		String sql = "select * from student where stu_username='" + username
				+ "'";
		Student stu = null;

		Connection conn = UtilDB.getConn();
		Statement sta = UtilDB.getSta(conn);

		ResultSet rs = UtilDB.getRes(sta, sql);
		try {
			while (rs.next()) {
				stu = new Student(rs.getString("stu_username"),
						rs.getString("stu_password"), rs.getString("stu_name"),
						rs.getString("stu_sex"), rs.getString("stu_class"));
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
		return stu;

	}
}
