<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="css/naviga.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
       <ul class="list">
       <li>
			<div class="border"></div>
			<span class="icon">Z</span>
			<div class="text">
				<h2><a href="view/student/student_main.jsp">首页</a></h2>
				<h3>home</h3>
			</div>
		</li>
		
		<li>
			<div class="border"></div>
			<span class="icon">N</span>
			<div class="text">
				<h2><a href="view/student/studentEvaluate.jsp">多媒体评价</a></h2>
				<h3>evaluation info</h3>
			</div>
		</li>
		<li>
			<div class="border"></div>
			<span class="icon">F</span>
			<div class="text">
				<h2><a href="view/student/studentInfo.jsp">修改个人信息</a></h2>
				<h3>student info</h3>
			</div>
		</li>
		<li>
			<div class="border"></div>
			<span class="icon">S</span>
			<div class="text">
				<h2><a href="view/student/studentChaPassword.jsp">修改密码</a></h2>
				<h3>change my password</h3>
			</div>
		</li>
	</ul>
       
  </body>
</html>
