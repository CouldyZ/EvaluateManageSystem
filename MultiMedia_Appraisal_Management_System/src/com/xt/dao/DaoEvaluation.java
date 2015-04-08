package com.xt.dao;

import java.util.List;

import com.xt.bean.Evaluation;

public interface DaoEvaluation {
	/*
	 * 增加评价
	 */
	public boolean addEvaluation(Evaluation evaluation);

	/*
	 * 查询所有评价
	 */
	public List<Evaluation> queryAll();

	/*
	 * 根据用户名删除评价
	 */
	public boolean deleteEvaluationByName(String name);
}
