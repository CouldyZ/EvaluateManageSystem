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

		// �õ��û���������
		String username = request.getParameter("username").trim().toString();
		String password = request.getParameter("password").trim().toString();

		// ����session
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);

		// �õ�����Ա����Ϣ
		ImplAdmin dao = new ImplAdmin();
		Admin admin = dao.getAdmin();

		if (admin.getUsername().equals(username)
				&& admin.getPassword().equals(password)) {

			request.getRequestDispatcher("view/admin/admin_main.jsp").forward(
					request, response);

		} else {
			// �õ�ѧ������Ϣ
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
					out.println("<script>alert('�û��������������');window.history.go(-1);</script>");
				}
			} else {
				out.println("<script>alert('�û������ڣ�');window.history.go(-1);</script>");
			}

		}

	}

	/**
	 * ��֤�����Ƿ����
	 * 
	 * @param username
	 * @return ������
	 */
	public String checkEvaExit(String username) {
		String flag = "������";
		Evaluation eva = new ImplEvaluation().queryOne(username);
		if (eva == null) {
			flag = "δ����";
		} else {
			flag = "������";
		}
		return flag;
	}

}
