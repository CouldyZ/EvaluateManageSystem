<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/main.css" type="text/css" rel="stylesheet">
    
  </head>
  
  <body background="image/bg.png">
  
     <jsp:include page="/head.jsp"/>
     
	  <table class ="content">
	  
	  <!-- 左边的导航 -->
		  <tr>
		    <td valign="top" >
		    <div style="margin-top:42px;margin-left:4px;">
		    <jsp:include page="student_left.jsp"/></div>
		    </td>
		    
		    <!-- 右边的内容 -->
		    <td valign="top" >
			    <div class ="content_right" style="margin-top:42px;">
			    <br><br><br>
			     <p class="content_title" >
			      <br>
					欢迎来到高校多媒体课堂评价管理系统
			    </div>
		     </td>
		  </tr>
		  
	  </table>
	  
  </body>
</html>
