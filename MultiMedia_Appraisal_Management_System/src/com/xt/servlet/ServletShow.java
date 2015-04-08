package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.bean.Evaluation;
import com.xt.bean.Student;
import com.xt.imp.ImplEvaluation;
import com.xt.imp.ImplStudent;
import com.xt.utils.UtilConfig;

/*
 * 处理查询列表信息
 * */
public class ServletShow extends HttpServlet {

	private static final long serialVersionUID = 4286155891621817116L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		String flag = request.getParameter("flag");

		if ("eva".equals(flag)) {

			// 得到评价列表的信息
			List<Evaluation> evaluations = new ImplEvaluation().queryAll();
			request.setAttribute("evaluations", evaluations);
			request.getRequestDispatcher("view/admin/adminEvaluates.jsp")
					.forward(request, response);

		} else if ("stu".equals(flag)) {

			// 得到学生列表的信息
			List<Student> students = new ImplStudent().queryAll();
			request.setAttribute("students", students);
			request.getRequestDispatcher("view/admin/adminStuManager.jsp")
					.forward(request, response);

		} else {
			out.println();
		}

	}

}
