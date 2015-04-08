package com.xt.dao;

import java.util.List;

import com.xt.bean.Student;

public interface DaoStudent {

	/*
	 * ����ѧ���˺�
	 */
	public boolean addStudent(Student student);

	/*
	 * �޸�ѧ��������Ϣ
	 */
	public boolean updateStudent(Student student);

	/*
	 * �޸�����
	 */
	public boolean updateStudentPwd(Student student);

	/*
	 * ����ѧ�� ɾ�� ѧ����¼
	 */
	public boolean deleteStudentByName(String num);

	/*
	 * ��ѯ����ѧ����Ϣ
	 * 
	 * �ɹ��򷵻�һ��ѧ���б�
	 */
	public List<Student> queryAll();
}
