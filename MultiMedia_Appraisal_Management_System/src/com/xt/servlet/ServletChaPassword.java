package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.bean.Admin;
import com.xt.bean.Student;
import com.xt.imp.ImplAdmin;
import com.xt.imp.ImplStudent;
import com.xt.utils.UtilConfig;

/*
 * 修改密码
 * */
public class ServletChaPassword extends HttpServlet {

	private static final long serialVersionUID = -521997891412951364L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		String password1 = request.getParameter("password1").trim();

		String flag = request.getParameter("flag");

		String username = request.getSession().getAttribute("username")
				.toString();

		if ("student".equals(flag)) {
			ImplStudent dao = new ImplStudent();
			Student student = new Student(username, password1);

			if (dao.updateStudentPwd(student)) {
				out.println("<script>alert('修改密码成功！请重新登录~');window.location.href='logout.jsp';</script>");
			} else {
				out.println("<script>alert('哇哦，貌似失败了，再试一次呗！');window.history.go(-1);</script>");
			}
		} else if ("admin".equals(flag)) {
			ImplAdmin dao = new ImplAdmin();
			Admin admin = new Admin(username, password1);
			dao.setPwd(admin);
			out.println("<script>alert('修改密码成功！请重新登录~');window.location.href='logout.jsp';</script>");
		}

	}
}
