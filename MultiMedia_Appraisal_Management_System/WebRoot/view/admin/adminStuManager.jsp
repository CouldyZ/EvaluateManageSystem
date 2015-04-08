<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminStuManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/main.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" media="all"/>
  </head>
  
    <body background="image/bg.png">
  
      <jsp:include page="/head.jsp"/>
     
	  <table class ="content">
	  
	      <!-- 左边的导航 -->
		  <tr>
		    <td valign="top" >
		    <div style="margin-top:42px;margin-left:4px;">
		    <jsp:include page="admin_left.jsp"/></div>
		    </td>
		    
		    <!-- 右边的内容 -->
		    <td valign="top" >
			    <div class ="content_right" style="margin-top:42px;">
			    <div id="container">   
			    
				<table class="zebra">
				    <caption class="content_title">学生管理页面--所有学生信息</caption>
						<thead>
				        	<tr>
								<th>登录名(学号)</th>
								<th>密码</th>
								<th>姓名</th>
								<th>性别</th>
								<th>班级</th>
								<th>删除</th>
				            </tr>
						</thead>
						
				        <tbody>
				            <c:forEach items="${students}" var="student">
								<tr align="center">
									<td>
										${student.stu_username}
									</td>
									<td>
										${student.stu_password}
									</td>
									<td>
										${student.stu_name}
									</td>
									<td>
										${student.stu_sex}
									</td>
									<td>
										${student.stu_class}
									</td>
									<td>
										<a href="ServletDelete?flag=stu&value=${student.stu_username}">删除</a>
									</td>
								</tr>
							</c:forEach>
				           </tbody>
					</table>
					
              </div>
			  </div>
			</td>
		 </tr>
	  </table>
	</body>
</html>  
