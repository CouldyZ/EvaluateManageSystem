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
 * 评价处理
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
			out.println("<script>alert('保存分数在0-100之间！');window.history.go(-1);</script>");
		} else {
			String content = request.getParameter("content").trim();

			String username = request.getSession().getAttribute("username")
					.toString().trim();

			Evaluation evaluation = new Evaluation(username, score, content);

			ImplEvaluation dao = new ImplEvaluation();
			String check = checkEvaExit(username);
			if ("未评价".equals(check)) {
				if (dao.addEvaluation(evaluation)) {
					request.getSession().setAttribute("evaluated",
							checkEvaExit(username));
					out.println("<script>alert('保存评价成功！');window.history.go(-1);</script>");
				} else {
					out.println("<script>alert('保存评价失败！');window.history.go(-1);</script>");
				}
			} else {
				if (dao.updateEvaluation(evaluation)) {
					request.getSession().setAttribute("evaluated",
							checkEvaExit(username));
					out.println("<script>alert('保存评价成功！');window.history.go(-1);</script>");
				} else {
					out.println("<script>alert('保存评价失败！');window.history.go(-1);</script>");
				}
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

	/**
	 * 判断0-100
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
