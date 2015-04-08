<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/box.css"/>
	<link href="css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/resetpwd.js"></script>
    
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
			     <p class="content_title" >
			      <br>
					  --个人信息管理<br>
					<!-- 重置密码框 --> 
			   <div class="content_div" style="width: 450px; height: 250px;margin-top:10px;">
			    
			    <form action="ServletChaPassword?flag=admin" method="post" name="form" onSubmit="return checkResetPwd(this);">
			    
				    <div align="center">
						        <!-- 管理个人信息 -->
                          <div>
                          <a href="/MultiMedia_Appraisal_Management_System/view/admin/adminChaPassword.jsp" style="color: #F90;">修改管理员密码</a>
                          &nbsp
                          <a href="/MultiMedia_Appraisal_Management_System/view/admin/adminChaInfo.jsp" style="color: #F90;">修改管理员信息</a>
                          </div>
                          <div>
                          <p>
                          <br><br>
                          用户名：<%=request.getSession().getAttribute("username") %>
                          </p>
                          
                          <p><br><br>
                           密&nbsp码&nbsp&nbsp：<%=request.getSession().getAttribute("password") %>
                          </p>
                          </div>
			        </div>
			        
			    </form>
			    
	           </div>
			   </div>
		     </td>
		  </tr>
	  </table>
	  
  </body>
</html>