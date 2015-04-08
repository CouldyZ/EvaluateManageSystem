<%@ page import="javax.mail.Session"%>
<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="login page">

    <link rel="stylesheet" type="text/css" href="css/box.css"/>
    </head>
  
  <body>
  
  <%
	 response.setHeader("refresh","2;url=login.jsp");//定时跳转
	 session.removeAttribute("username");
	 session.invalidate();//注销
	%>
  
       <!-- 标题 -->
	   <DIV class="top_div">
	     <p class="top_text">
			<br>高校多媒体课堂评价管理系统
		 </p>
	   </DIV>
	   
	   <!-- 登陆框 -->
	   <DIV class="content_div" style="width: 450px; height: 250px;">
	        <div align="center">
	        <br><br><br>
		      <h3>您已经退出本系统,两秒后跳会登录页</h3>
              <h3>如没有跳转,请按<a href="login.jsp">这里</a></h3>
		   </div>
	   </DIV>
	    
  </body>
</html>