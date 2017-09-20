<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>企业管理信息系统</title>
	<style type="text/css">
			
	</style>
		
	<script type="text/javascript">
	
		///登录过期
		function noLogin(){
			window.location.href = "${contextPath}/index.jsp" ;
		}
	</script>
</head>
		<frameset rows="60,*" cols="*" frameborder="0">
			<frame name="top" style="border-bottom:1px solid #888; " src="${contextPath }/home/toTop.com"/>
			<frameset cols="187,*" frameborder="0" >
				<frame name="left" style="border-right: 1px solid #888;" src="${contextPath }/sys/MenuAction/left.com"/>
				<frame name="center" src="${contextPath }/home/toCenter.com"/>
			</frameset>
		</frameset>	
	
	
</html>