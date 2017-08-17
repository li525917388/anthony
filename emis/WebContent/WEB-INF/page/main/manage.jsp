<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
		<frameset rows="60,*" cols="*" frameborder="1">
			<frame name="top" src="top.html"/>
			<frameset cols="187,*" frameborder="1" >
				<frame name="left" src="${contextPath }/sys/MenuAction/left.com"/>
				<frame name="center" src="center.html"/>
			</frameset>
		</frameset>	
	
</html>