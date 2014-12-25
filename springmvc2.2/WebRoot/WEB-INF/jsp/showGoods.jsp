<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript">
  	function jackson(){
  		alert('shit');
  		$.getJSON("jackson.do", {}, function(data){
  			for(var i=0,len=data.length;i<len;++i){
  				alert(data[i].gname);
  			}
  		});
  	}
  </script>
  <body>
  	<a href='goToUp.do'>上传文件</a>
  	<a href='javascript: jackson()'>阿贾克斯</a>
  	<a href='getExcel.do'>Excel</a>
  	<a href='getPdf.do'>Pdf</a>
  	<div>
  		<c:if test="${not empty loginUser}">
  			<div style='float: right'>${loginUser.username}, 欢迎你</div>
  		</c:if>
  		<c:if test="${not empty msg}">
  			<div style='float: right'>给管理员的留言:${msg}</div>
  		</c:if>
  	</div>
    <table>
    	<tr>
    		<td>商品名称</td>
    		<td>商品价格</td>
    	</tr>
    	<c:forEach items='${goodsList}' var='g'>
    		<tr>
    			<td>${g.gname}</td>
    			<td>${g.price}</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
