package com.xt.bean;

import com.xt.utils.UtilTime;

/*
 * 评价
 * */
public class Evaluation {

	// 评价人
	private String eva_name;
	// 评价的分数
	private String eva_score;
	// 评价的内容
	private String eva_content;
	// 评价的日期
	private String eva_date;

	public Evaluation(String eva_name, String eva_score, String eva_content) {
		super();
		this.eva_name = eva_name;
		this.eva_score = eva_score;
		this.eva_content = eva_content;
		this.eva_date = UtilTime.getTime();
	}

	public Evaluation(String eva_name, String eva_score, String eva_content,
			String eva_date) {
		super();
		this.eva_name = eva_name;
		this.eva_score = eva_score;
		this.eva_content = eva_content;
		this.eva_date = eva_date;
	}

	public String getEva_name() {
		return eva_name;
	}

	public void setEva_name(String eva_name) {
		this.eva_name = eva_name;
	}

	public String getEva_score() {
		return eva_score;
	}

	public void setEva_score(String eva_score) {
		this.eva_score = eva_score;
	}

	public String getEva_content() {
		return eva_content;
	}

	public void setEva_content(String eva_content) {
		this.eva_content = eva_content;
	}

	public String getEva_date() {
		return eva_date;
	}
}
