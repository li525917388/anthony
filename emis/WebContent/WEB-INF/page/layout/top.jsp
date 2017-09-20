<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link href="${contextPath }/static/temp/css/bootstrap.css" rel="stylesheet">
	
	
	<script src='${contextPath }/static/awesome/js/jquery.js'></script>
	<script src='${contextPath }/static/temp/js/bootstrap.js'></script>
	<style type="text/css">
		body{
			background: #333;
			margin: 0px;
			padding: 0px;
		} 
		
		body nav{
			margin: 0px;
			margin-bottom: 0px !important;
		}
	</style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation"> 
    <div class="container-fluid"> 
        <div class="navbar-header"> 
            <a class="navbar-brand" href="#">菜鸟教程</a> 
        </div> 
        <ul class="nav navbar-nav navbar-right"> 
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li> 
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li> 
        </ul> 
    </div> 
</nav>
</body>
</html>