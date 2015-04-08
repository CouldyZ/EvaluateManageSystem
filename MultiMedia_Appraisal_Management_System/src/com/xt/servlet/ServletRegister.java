package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.bean.Student;
import com.xt.imp.ImplStudent;
import com.xt.utils.UtilConfig;

/*
 * 处理注册的表单
 * */
public class ServletRegister extends HttpServlet {

	private static final long serialVersionUID = -5695937620647969505L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		String stu_username = request.getParameter("username").trim();
		if (!isNumber(stu_username)) {
			out.println("<script>alert('用户名为9位数字~');window.history.go(-1);</script>");
		} else {
			String stu_password = request.getParameter("password").trim();

			String stu_name = request.getParameter("name").trim();
			String stu_sex = request.getParameter("sex").trim();
			String stu_class = request.getParameter("class").trim();

			Student student = new Student(stu_username, stu_password);
			if (!checkExit(stu_username)) {
				student = new Student(stu_username, stu_password, stu_name,
						stu_sex, stu_class);
				// 加入数据库，提示成功。并返回登陆界面
				ImplStudent dao = new ImplStudent();
				if (dao.addStudent(student)) {
					out.println("<script>alert('注册成功！~');window.location.href='login.jsp';;</script>");

				} else {
					out.println("<script>alert('注册失败！重试呗~');window.history.go(-1);</script>");
				}

			} else {
				// 提示该用户已存在。并返回注册界面
				out.println("<script>alert('用户名已存在！');window.history.go(-1);</script>");
			}
		}
	}

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 * @return false 不存在
	 */
	public boolean checkExit(String username) {
		return new ImplStudent().queryOne(username) == null ? false : true;
	}

	/**
	 * 判断为九位数字
	 */
	public boolean isNumber(String num) {
		boolean flag = false;
		try {
			int number = Integer.valueOf(num);
			if (num.length() == 9 && number > 0) {
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
}
