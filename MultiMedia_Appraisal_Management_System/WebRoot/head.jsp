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
    <link href="css/main.css" type="text/css" rel="stylesheet">
    
  </head>
  
  <body>
  
       <div class="head_div">
			<br>
			<p class="head_title">
			高校多媒体课堂评价管理系统
		    </p>
		    
			<span style="float: right;">
	        <A href="logout.jsp">注销</A>  
	        </span>
       </div>
       
       <div class="head_divider">
		     <p class="head_wel"> 欢迎你 : <%=request.getSession().getAttribute("username")%></p>
	   </div>
       
  </body>
</html>
