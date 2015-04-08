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
	<script type="text/javascript" src="js/checklogin.js"></script>

    </head>
  
  <body>
  
       <!-- 标题 -->
	   <DIV class="top_div">
	     <p class="top_text">
			<br>高校多媒体课堂评价管理系统
		 </p>
	   </DIV>
	   
	   <!-- 登陆框 -->
	   <DIV class="content_div" style="width: 450px; height: 250px;">
	 
		   <form action="ServletLogin" method="post" name="form1" onSubmit="return checkLogin(this);">
		    
		        <!-- 两个输入框 -->
			    <P style="padding: 50px 0px 10px; position: relative;">
				<INPUT class="ipt" type="text" placeholder="请输入学号或账号名" name="username">
				</P>
				
				<P style="padding: 5px 0px 10px;position: relative;">       
				<INPUT class="ipt" id="password" type="password" placeholder="请输入密码" name="password">   
				</P>
				
					
				<!-- 分割线 、两个按钮 -->	
				<DIV class="btns_div">
					<P style="margin: 20px 80px 30px 50px;">
						<SPAN style="float: left;margin-left:30px">
					     <A href="register.jsp">注册</A>  
					    </SPAN>
				        <input class="button" type="submit" value="登录"/>
				    </P>
				</DIV>
				
		  </form>
		  
	   </DIV>
	    
  </body>
</html>
