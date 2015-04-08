package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.bean.Evaluation;
import com.xt.imp.ImplEvaluation;
import com.xt.utils.UtilConfig;

/*
 * ���۴���
 * */
public class ServletEvaluate extends HttpServlet {

	private static final long serialVersionUID = 8397863158913444867L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilConfig.encoding(request, response);
		PrintWriter out = response.getWriter();

		String score = request.getParameter("score").trim();
		if (!isNumber(score)) {
			out.println("<script>alert('���������0-100֮�䣡');window.history.go(-1);</script>");
		} else {
			String content = request.getParameter("content").trim();

			String username = request.getSession().getAttribute("username")
					.toString().trim();

			Evaluation evaluation = new Evaluation(username, score, content);

			ImplEvaluation dao = new ImplEvaluation();
			String check = checkEvaExit(username);
			if ("δ����".equals(check)) {
				if (dao.addEvaluation(evaluation)) {
					request.getSession().setAttribute("evaluated",
							checkEvaExit(username));
					out.println("<script>alert('�������۳ɹ���');window.history.go(-1);</script>");
				} else {
					out.println("<script>alert('��������ʧ�ܣ�');window.history.go(-1);</script>");
				}
			} else {
				if (dao.updateEvaluation(evaluation)) {
					request.getSession().setAttribute("evaluated",
							checkEvaExit(username));
					out.println("<script>alert('�������۳ɹ���');window.history.go(-1);</script>");
				} else {
					out.println("<script>alert('��������ʧ�ܣ�');window.history.go(-1);</script>");
				}
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

	/**
	 * �ж�0-100
	 */
	public boolean isNumber(String num) {
		boolean flag = false;
		try {
			int number = Integer.valueOf(num);
			if (0 <= number && 100 >= number) {
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

}
