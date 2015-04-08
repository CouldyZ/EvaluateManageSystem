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
 * ����ע��ı�
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
			out.println("<script>alert('�û���Ϊ9λ����~');window.history.go(-1);</script>");
		} else {
			String stu_password = request.getParameter("password").trim();

			String stu_name = request.getParameter("name").trim();
			String stu_sex = request.getParameter("sex").trim();
			String stu_class = request.getParameter("class").trim();

			Student student = new Student(stu_username, stu_password);
			if (!checkExit(stu_username)) {
				student = new Student(stu_username, stu_password, stu_name,
						stu_sex, stu_class);
				// �������ݿ⣬��ʾ�ɹ��������ص�½����
				ImplStudent dao = new ImplStudent();
				if (dao.addStudent(student)) {
					out.println("<script>alert('ע��ɹ���~');window.location.href='login.jsp';;</script>");

				} else {
					out.println("<script>alert('ע��ʧ�ܣ�������~');window.history.go(-1);</script>");
				}

			} else {
				// ��ʾ���û��Ѵ��ڡ�������ע�����
				out.println("<script>alert('�û����Ѵ��ڣ�');window.history.go(-1);</script>");
			}
		}
	}

	/**
	 * �ж��û����Ƿ����
	 * 
	 * @param username
	 * @return false ������
	 */
	public boolean checkExit(String username) {
		return new ImplStudent().queryOne(username) == null ? false : true;
	}

	/**
	 * �ж�Ϊ��λ����
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
