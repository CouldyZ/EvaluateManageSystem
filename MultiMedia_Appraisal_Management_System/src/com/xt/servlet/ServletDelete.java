package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.imp.ImplEvaluation;
import com.xt.imp.ImplStudent;
import com.xt.utils.UtilConfig;

public class ServletDelete extends HttpServlet {

	private static final long serialVersionUID = -4097426444377504912L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		// �õ��б��е�ֵ
		String flag = request.getParameter("flag");
		String value = request.getParameter("value");

		boolean success = false;
		ImplEvaluation impl = new ImplEvaluation();
		if ("eva".equals(flag)) {
			// ɾ������
			success = impl.deleteEvaluationByName(value);
		} else if ("stu".equals(flag)) {
			// ɾ��ѧ����ͬʱ��Ҫɾ������
			ImplStudent dao = new ImplStudent();
			success = dao.deleteStudentByName(value);
			if (success) {
				success = impl.deleteEvaluationByName(value);
			}
		}

		if (success) {
			out.println("<script>alert('ɾ���ɹ���');window.history.go(-1);</script>");
		} else {
			out.println("<script>alert('ɾ��ʧ�ܣ�');window.history.go(-1);</script>");
		}
	}
}
