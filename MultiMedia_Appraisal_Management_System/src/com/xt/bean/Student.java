package com.xt.bean;
/*
 * ѧ����bean
 * */
public class Student {
	
	//��½�˺ţ�ѧ�ţ�
	private String stu_username;
	//��½����
	private String stu_password;
	//ѧ��������
	private String stu_name;
	//ѧ���Ա�
	private String stu_sex;
	//ѧ���İ༶��Ϣ
	private String stu_class;
	
	
    public Student() {
		super();
	}

	public Student(String stu_username, String stu_password) {
		super();
		this.stu_username = stu_username;
		this.stu_password = stu_password;
	}
	
	public Student(String stu_username,  String stu_name,
			String stu_sex, String stu_class) {
		super();
		this.stu_username = stu_username;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_class = stu_class;
	}
	
	public Student(String stu_username, String stu_password, String stu_name,
			String stu_sex, String stu_class) {
		super();
		this.stu_username = stu_username;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_class = stu_class;
	}
	
	public String getStu_username() {
		return stu_username;
	}
    
	public void setStu_username(String stu_username) {
		this.stu_username = stu_username;
	}
	
	public String getStu_password() {
		return stu_password;
	}
	
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	
	public String getStu_name() {
		return stu_name;
	}
	
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	public String getStu_sex() {
		return stu_sex;
	}
	
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	
	public String getStu_class() {
		return stu_class;
	}
	
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	

}
