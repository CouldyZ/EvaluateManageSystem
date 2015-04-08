package com.xt.utils;

import java.sql.*;

/*
 * 数据库操作
 * */
public class UtilDB {
	
 //得到连接
 public static Connection getConn(){
	 
	 Connection conn=null;
	 try {
		Class.forName(UtilConst.DRIVER);
		conn = 
				DriverManager.getConnection(UtilConst.URL,
											UtilConst.USER_NAME,
											UtilConst.PWD);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	 
	 return conn;
 }
 
 //得到状态机
 public static Statement getSta(Connection conn){
	 Statement sta=null;
	 if(conn!=null){
		 try {
			sta=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }	 
	 return sta;
 }
 
 //获得结果集
 public static ResultSet getRes(Statement sta,String sql){
	 ResultSet rs=null;
	 try{
	 if(sta!=null){	
			rs=sta.executeQuery(sql);
	 }	 }
	 catch(SQLException e){
		 e.printStackTrace();
	 }
	 return rs;
 }
 
 //关闭连接
 public static void closeConn(Connection conn){
		try {
			if(conn!=null){	
			      conn.close();
		          conn=null;
	           }	
			} catch (SQLException e) {
			e.printStackTrace();
		}
 }
 
}
