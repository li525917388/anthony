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
	<link href="${contextPath }/static/awesome/css/font-awesome.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="${contextPath }/static/awesome/css/style.css" media="screen" type="text/css" />
   	
   	<script src='${contextPath }/static/awesome/js/jquery.js'></script>
  	<script src="${contextPath }/static/awesome/js/index.js"></script>

	 <script>
 		 $(function() {
   			/* var icons = {
      			header: "ui-icon-circle-arrow-e",
      			activeHeader: "ui-icon-circle-arrow-s"
    		}; */
   			
   		 	/* $( "#accordion" ).accordion({
      			icons: icons,
      			heightStyle: "content"
    		}); */

  		});
  	</script>
  
   <style>
  		#feedback { font-size: 1.4em; }
  		#selectable .ui-selecting { background: #FECA40; }
 		 #selectable .ui-selected { background: #F39814; color: white; }
  		#selectable { list-style-type: none; margin: 0; padding: 0; width: 100%; }
 		#selectable li { margin: 2px; padding: 0.4em; font-size: 14px; height: 18px; }
 		#accordion .cmenu{margin:0px;padding:0px;}
  </style>
  <script>
  $(function() {
    $( "li" ).click(function(){
    	$( "li" ).css("background","") ;
    	$(this).css("background","#ee6600") ;
    }) ;
  });
  </script>
</head>
<body>

	<ul id="accordion" class="accordion">
		<c:forEach items="${menuList }" var="ml">
		<li>
			<div class="link"><i class="fa ${ml.icon }"></i>${ml.mname }<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
			<c:forEach items="${ml.cMenus }" var="cms">
				<li><a onclick="toMenu('${cms.url }')" href="#">${cms.mname } <span class="badge">50</span></a></li>
			</c:forEach>
			</ul>
		</li>
		</c:forEach>
	</ul>
	
	
	<script>
		function toMenu(url){
			top.center.location.href = "${contextPath }/"+url +".com" ;
		}
	</script>

</body>
</html>