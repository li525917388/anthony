<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${contextPath}/css/demo.css" type="text/css">
	<link rel="stylesheet" href="${contextPath}/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="${contextPath}/layer/skin/default/layer.css" />
	<script type="text/javascript" src="${contextPath}/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${contextPath}/js/jquery.ztree.excheck.js"></script>
	<script src="${contextPath}/layer/layer.js"></script>


	<SCRIPT type="text/javascript">
		$(function(){
			var setting = {
				check: {
					enable: true,
					chkDisabledInherit: true
				},
				data: {
					simpleData: {
						enable: true
					}
				}
			};
				
			$.ajax({
				url: "${contextPath}/sys/role/getRoleTree.com",
				type: "post",
				data: {uid:$("#userId").val()},
				//dataType: "json",
				success: function(res){
					
					$(document).ready(function(){
						$.fn.zTree.init($("#treeDemo"), setting, eval(res));		
					});
						
				}
			});
		})
		

		/* var zNodes =[
			{ id:1, pId:0, name:"随意勾选 1", open:true},
			{ id:2, pId:1, name:"随意勾选 1-1", open:false},
			{ id:3, pId:2, name:"disabled 1-1-1"},
			{ id:4, pId:2, name:"随意勾选 1-1-2"},
			{ id:5, pId:1, name:"disabled 1-2", chkDisabled:false, checked:true, open:false},
			{ id:6, pId:5, name:"disabled 1-2-1", checked:true},
			{ id:7, pId:5, name:"disabled 1-2-2"},
			{ id:8, pId:0, name:"随意勾选 2", checked:false, open:false},
			{ id:9, pId:8, name:"随意勾选 2-1"},
			{ id:10, pId:8, name:"随意勾选 2-2"},
			{ id:11, pId:10, name:"随意勾选 2-2-1", checked:false},
			{ id:12, pId:10, name:"随意勾选 2-2-2"},
			{ id:13, pId:8, name:"随意勾选 2-3"}
		];

		

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);		
		}); */
		
		
		//保存新权限
		function saveUserRole () {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = zTree.getCheckedNodes(true);
		//	alert(nodes.length);
			var mids = "" ;
			for(var i in nodes){
				mids += nodes[i].id + "," ;
			}
			
			$.ajax({
				url: "${contextPath}/sys/role/saveUserRole.com",
				data: {rids : mids,uid : $("#userId").val()},
				type: "post",
				success: function(res) {
					parent.layer.closeAll() ;
					parent.$("#grid-table").trigger("reloadGrid");
					parent.layer.msg("操作成功");
				}
			});
		}
		
	</SCRIPT>
</head>

<body>
	<input id="userId" value="${userId }" type="hidden" autocomplete="off">
	<div style="width: 500px;height: 400px;padding: 10px;">
		<ul id="treeDemo" class="ztree" style="width: 100%;height: 100%;border: none;"></ul>
	</div>

</body>
</html>