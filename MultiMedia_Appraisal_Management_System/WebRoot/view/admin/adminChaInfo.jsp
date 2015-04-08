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
	    <td valign="top">
	       <div class ="content_right" style="margin-top:42px;">
	         <p class="content_title" >
			      <br>
					  --修改管理员个人信息<br>
					  <!-- 修改个人信息表单 -->
			<div class="content_div" style="width: 450px; height: 280px;margin-top:10px;">
	        
		        <form action="ServletAlterStuInfo?flag=admin" method="post" name="form" onSubmit="return checkInfo(this);">
		        
		        <div align="center">
						        <!-- 两个输入框 -->
						<P style="padding: 50px 0px 10px; position: relative;">
					    <textarea class="ipt" name="info" cols="32" rows="4" placeholder="个人信息" style="width:290px;"></textarea>
						</P>
						
						<!-- 确定按钮 -->
					    <div class="btns_div">
							<P style="margin: 20px 80px 40px 50px;">
								<span style="float: center;margin-right:2px;margin-top:10px">
								<input type="submit" value="保存并修改" class="button" style="width:290px" onclick="checkNull()" />
								</span>
							</P>
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