<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<script src='${contextPath}/assets/js/jquery-2.0.3.min.js'></script>
</head>
	<style type="text/css">
		input:-webkit-autofill {
   	 		-webkit-text-fill-color: #ededed !important;  
   		 	-webkit-box-shadow: 0 0 0px 1000px transparent  inset !important;  
    		background-color:transparent;  
    		background-image: none;  
     		transition: background-color 50000s ease-in-out 0s;
 
		}
		body{
			font-family: "微软雅黑";
			background: url(images/bg4.jpg) no-repeat;
			background-size: 100% 120%;
			height: 100%;
			margin: 0px;
			padding: 0px;
		}
		#login_panel{
			width: 400px;
			height: 300px;
			margin: 150px auto;
			color: #eee;
		}
		#login_bg{
			background: #666;
			width: 400px;
			height: 300px;
			opacity: 0.5;
			position: absolute;
			border-radius: 5px;
			z-index: -10;
		}
		#login_panel .login_tr{
			line-height: 40px;
			width: 250px;
			height: 40px;
			margin: 10px auto;
			border: 1px solid #ccc;
		}
		
		#login_panel .login_tr .tr_bg{
			background: #452;
			opacity: 0.5;
			position: absolute;
			width: 250px;
			height: 40px;
			z-index: -1;
		}
		
		#login_panel .login_tr label{
			margin-left: 10px;	
		}
		#login_panel .login_tr input{
			font-size: 15px;
			width: 180px;
			color: #eee;
			background: none;
			border: none;
			outline: none;
		}
		
		
		#login_panel #login_btn_tr{
			border: none;
			background: #fafafa;
			color: #6b4;
			text-align: center;

		}
		
		#login_panel #login_btn_tr input{
			font-size: 18px;
			color: #00B83F;
			font-weight: bold;
			width: 250px;
			height: 40px;
			cursor: pointer;
		}
		
		#login_panel #login_btn_tr input:hover{
			background: #e3e3e3;

		}
		
		#login_panel #login_btn_tr input:active{
			background: #ccc;
	
		}
	</style>
	<body >
	
		<div id="login_panel" >
			<div id="login_bg"></div>
			
			<div id="" style="height: 120px;font-size: 35px;color: white;text-align: center;line-height: 100px;">
				企业信息管理系统
			</div>
			<div class="login_tr">
				<div class="tr_bg"></div>
				<label>帐号：</label><input id="userName"  type="text" />
			</div>
			<div class="login_tr">
				<div class="tr_bg"></div>
				<label>密码：</label><input id="password" type="password" />
			</div>
			<div class="login_tr" id="login_btn_tr">
				<input type="button" onclick="login()" value="登录"/>
			</div>
		</div>
		
		<script type="text/javascript">
			function login(){
				var uname = $("#userName").val();
				var pwd = $("#password").val();
				
				if(uname == ""){
					alert("帐号不能为空");
					return;
				}
				if(pwd == ""){
					alert("密码不能为空");
					return;
				}
				
				$.ajax({
					url: "${contextPath}/sys/user/login.com",
					data: {userName:uname,pwd:pwd},
					type: "post",
					success: function(res){
						if(res == 'suc'){
							location.href='${contextPath}/home/admin.com';
						}else{
							alert("帐号或密码错误");
						}
					}
				});
			}
		</script>
	</body>
</html>