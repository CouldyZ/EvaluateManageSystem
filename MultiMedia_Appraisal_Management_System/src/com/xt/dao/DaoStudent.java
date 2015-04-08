package com.xt.dao;

import java.util.List;

import com.xt.bean.Student;

public interface DaoStudent {

	/*
	 * 增加学生账号
	 */
	public boolean addStudent(Student student);

	/*
	 * 修改学生个人信息
	 */
	public boolean updateStudent(Student student);

	/*
	 * 修改密码
	 */
	public boolean updateStudentPwd(Student student);

	/*
	 * 根据学号 删除 学生记录
	 */
	public boolean deleteStudentByName(String num);

	/*
	 * 查询所有学生信息
	 * 
	 * 成功则返回一个学生列表
	 */
	public List<Student> queryAll();
}
