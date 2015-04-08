<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/box.css"/>
    <script type="text/javascript" src="js/checkreg.js"></script>
    
  </head>
  
  <body >
  
       <!-- 标题 -->
	   <DIV class="top_div">
	   <a href="login.jsp" style="margin-left:5px;">返回登陆页面</a>
	   <p class="top_text">
			<br>高校多媒体课堂评价管理系统
		</p>
	   </DIV>
	    
	    <!-- 注册框 -->
	   <DIV class="content_div" style="width: 450px; height: 340px;">
	    
	    <form action="ServletRegister" method="post" name="form" onSubmit="return checkReg(this);">
		    
		    <P style="padding: 30px 0px 10px; position: relative;">
			<INPUT class="ipt" type="text" placeholder="学号（登录名）" name="username" > 
			</P>
			
			<P style="position: relative;">       
			<INPUT class="ipt" type="password" placeholder="密码" name="password" >   
			</P>
			
			<P style="padding: 10px 0px 10px; position: relative;">
			<INPUT class="ipt" type="text" placeholder="姓名" name="name">   
			</P>
			
			<P style="position: relative;"> 
			<select name="sex" class="ipt">
			<option value="男">男</option>
			<option value="女">女</option>
			</select>    
			</P>
			
			<P style="padding: 10px 0px 10px; position: relative;">   
			<INPUT class="ipt" type="text" placeholder="班级" name="class">   
			</P>
			
			<DIV class="btns_div">
				<P style="margin: 20px 80px 30px 50px;">
					<SPAN style="float: center;margin-right:2px;margin-top:10px">
					<input type="submit" value="注册" class="button" style="width:290px"/>
					</SPAN>
				</P>
	        </DIV>
	        
	    </form>
	    </DIV>
  </body>
</html>
