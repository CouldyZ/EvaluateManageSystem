<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentEvaluate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
   <link rel="stylesheet" type="text/css" href="css/box.css"/>
   <link href="css/main.css" type="text/css" rel="stylesheet">
   
   <script type="text/javascript" src="js/checkeva.js"></script>
  </head>
  
  <body background="image/bg.png" >
  
      <jsp:include page="/head.jsp"/>
     
	  <table class ="content">
	  
	  <!-- 左边的导航 -->
	  <tr>
	    <td valign="top">
	    <div style="margin-top:42px;margin-left:4px;">
	    <jsp:include page="student_left.jsp"/></div>
	    </td>
	    
	    <!-- 右边的内容 -->
	    <td valign="top">
	       <div class ="content_right" style="margin-top:42px;">
	         <p class="content_title" >
			      <br>
					  --评价页面(你<%=request.getSession().getAttribute("evaluated") %>)<br>
					  <!-- 评价表单 -->
			<div class="content_div" style="width: 450px; height: 280px;margin-top:10px;">
	        
		        <form action="ServletEvaluate" method="post" name="form" onSubmit="return checkEva(this);">
		        
		        <div align="center">
						        <!-- 两个输入框 -->
						<P style="padding: 50px 0px 10px; position: relative;">
					    <input class="ipt" name="score" placeholder="分数(1-100分)"  style="width:290px;" >
						</P>
							
						<P style="padding: 5px 0px 10px;position: relative;">       
						<textarea class="ipt" name="content" cols="32" rows="4" placeholder="评价(200字以内)" style="width:290px;"></textarea>
						</P>
						
					    <div class="btns_div">
							<P style="margin: 20px 80px 40px 50px;">
								<span style="float: center;margin-right:2px;margin-top:10px">
								<input type="submit" value="确认并提交" class="button" style="width:290px" onclick="checkNull()" />
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
