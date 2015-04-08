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
    
    <title>My JSP 'adminEvaluates.jsp' starting page</title>
    
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
		    <td valign="top">
		    <div style="margin-top:42px;margin-left:4px;">
		    <jsp:include page="admin_left.jsp"/></div>
		    </td>
		    
		    <!-- 右边的内容 -->
		    <td valign="top" >
			    <div class ="content_right" style="margin-top:42px;">
			    <div id="container">  
			    
			     <!-- 表格内容 -->
				<table class="zebra">
			    <caption class="content_title">评价管理页面--所有评价信息</caption>
			    
					<thead>
			        	<tr>
							<th>评价人</th>
							<th>评价分数</th>
							<th>评价内容</th>
							<th>评价日期</th>
							<th>操作</th>
			            </tr>
					</thead>
		
                     <tbody>
                           <c:forEach items="${evaluations}" var="evaluation">
									<tr align="center">
										<td>
											${evaluation.eva_name}
										</td>
										<td>
											${evaluation.eva_score}
										</td>
										<td>
											${evaluation.eva_content}
										</td>
										<td>
											${evaluation.eva_date}
										</td>
										<td>
										  <a href="ServletDelete?flag=eva&value=${evaluation.eva_name}">
										    删除</a>
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
