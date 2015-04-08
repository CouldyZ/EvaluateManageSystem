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
 * 修改个人信息
 * */
public class ServletAlterStuInfo extends HttpServlet {

	private static final long serialVersionUID = 4115679905274571243L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		String flag = request.getParameter("flag");
		if ("stu".equals(flag)) {

			String stu_name = request.getParameter("name").trim();
			String stu_sex = request.getParameter("sex").trim();
			String stu_class = request.getParameter("class").trim();

			String stu_username = request.getSession().getAttribute("username")
					.toString();

			Student student = new Student(stu_username, stu_name, stu_sex,
					stu_class);

			// 更新数据库，成功则返回主界面
			ImplStudent dao = new ImplStudent();
			boolean addOk = dao.updateStudent(student);
			if (addOk) {
				response.sendRedirect("view/student/student_main.jsp");
			} else {
				out.print("<script>alert('更新失败');window.history.go(-1);</script>");
			}

		} else if ("admin".equals(flag)) {
			String admin_info = request.getParameter("info").trim();

			ImplAdmin dao = new ImplAdmin();
			Admin admin = new Admin(dao.getAdmin().getUsername(), dao
					.getAdmin().getPassword(), admin_info);
			boolean ok = dao.UpdateInfo(admin);
			if (ok) {
				out.print("<script>alert('更新成功！');window.history.go(-1);</script>");
			} else {
				out.print("<script>alert('更新失败');window.history.go(-1);</script>");
			}

		}
	}

}
