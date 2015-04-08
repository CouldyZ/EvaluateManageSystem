package com.xt.dao;

import java.util.List;

import com.xt.bean.Evaluation;

public interface DaoEvaluation {
	/*
	 * ��������
	 */
	public boolean addEvaluation(Evaluation evaluation);

	/*
	 * ��ѯ��������
	 */
	public List<Evaluation> queryAll();

	/*
	 * �����û���ɾ������
	 */
	public boolean deleteEvaluationByName(String name);
}
