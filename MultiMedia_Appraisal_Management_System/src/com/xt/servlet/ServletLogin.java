package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.bean.Admin;
import com.xt.bean.Evaluation;
import com.xt.bean.Student;
import com.xt.imp.ImplAdmin;
import com.xt.imp.ImplEvaluation;
import com.xt.imp.ImplStudent;
import com.xt.utils.UtilConfig;

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 6206092371985498305L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		// 得到用户名和密码
		String username = request.getParameter("username").trim().toString();
		String password = request.getParameter("password").trim().toString();

		// 设置session
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);

		// 得到管理员的信息
		ImplAdmin dao = new ImplAdmin();
		Admin admin = dao.getAdmin();

		if (admin.getUsername().equals(username)
				&& admin.getPassword().equals(password)) {

			request.getRequestDispatcher("view/admin/admin_main.jsp").forward(
					request, response);

		} else {
			// 得到学生的信息
			ImplStudent impl = new ImplStudent();
			Student stu = impl.queryOne(username);
			if (stu != null) {
				String testPassword = stu.getStu_password().trim();
				request.getSession().setAttribute("evaluated",
						checkEvaExit(username));
				if (testPassword.equals(password)) {

					request.getRequestDispatcher(
							"view/student/student_main.jsp").forward(request,
							response);
				} else {
					out.println("<script>alert('用户名或者密码错误！');window.history.go(-1);</script>");
				}
			} else {
				out.println("<script>alert('用户不存在！');window.history.go(-1);</script>");
			}

		}

	}

	/**
	 * 验证评价是否存在
	 * 
	 * @param username
	 * @return 不存在
	 */
	public String checkEvaExit(String username) {
		String flag = "已评价";
		Evaluation eva = new ImplEvaluation().queryOne(username);
		if (eva == null) {
			flag = "未评价";
		} else {
			flag = "已评价";
		}
		return flag;
	}

}
