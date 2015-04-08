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

		// 得到列表中的值
		String flag = request.getParameter("flag");
		String value = request.getParameter("value");

		boolean success = false;
		ImplEvaluation impl = new ImplEvaluation();
		if ("eva".equals(flag)) {
			// 删除评价
			success = impl.deleteEvaluationByName(value);
		} else if ("stu".equals(flag)) {
			// 删除学生，同时需要删除评价
			ImplStudent dao = new ImplStudent();
			success = dao.deleteStudentByName(value);
			if (success) {
				success = impl.deleteEvaluationByName(value);
			}
		}

		if (success) {
			out.println("<script>alert('删除成功！');window.history.go(-1);</script>");
		} else {
			out.println("<script>alert('删除失败！');window.history.go(-1);</script>");
		}
	}
}
