<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>考核管理</title>
		<!-- basic styles -->
		<link href="${contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${contextPath}/assets/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${contextPath}/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="${contextPath}/assets/css/ui.jqgrid.css" />
		<link rel="stylesheet" href="${contextPath}/assets/css/datepicker.css" />
		<link rel="stylesheet" href="${contextPath}/layer/skin/default/layer.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${contextPath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${contextPath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${contextPath}/assets/css/ace-skins.min.css" />
		<!-- ace settings handler -->
	<%-- 	<script src="${contextPath}/assets/js/ace-extra.min.js"></script> --%>
	</head>

	<body>
	

					<div class="breadcrumbs" id="breadcrumbs">
						

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="${contextPath}/home/toCenter.com">首页</a>
							</li>
							<li class="active">
								<a href="#">系统管理</a>
							</li>
							<li class="active">
								菜单管理
							</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					<!-- /.breadcrumbs -->

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<table id="grid-table"></table>
								<div id="grid-pager"></div>
								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
							</div><!-- /.col-xs-12 -->
						</div><!-- /.row -->
					</div>
					<!-- /.page-content -->
				
			
	
		<!-- basic scripts -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${contextPath}/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
		</script>

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${contextPath}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
		</script>
		<script src="${contextPath}/assets/js/bootstrap.min.js"></script>
		<script src="${contextPath}/assets/js/typeahead-bs2.min.js"></script>
		
		<!-- page specific plugin scripts -->
		<script src="${contextPath}/assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${contextPath}/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="${contextPath}/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
		<script src="${contextPath}/layer/layer.js"></script>

		<script type="text/javascript">
			
			function del(){
				layer.open({
    		   		type : 2,
    		   		skin: 'layui-layer-lan', //加上边框
    		   		area: ['950px', '550px'], //宽高
    		   		fix: false,
    		   		title: '成绩详情',
    		   		content: 'gradedetail.html'
	    		})
			}
		

		
			
			jQuery(function($){
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				
				$(grid_selector).jqGrid({
					url: "${contextPath}/sys/MenuAction/getMenus.com",
					subGrid : false,
					datatype: "json",
					height: 400,
					colNames:[' ','主键','菜单名称','菜单编码','菜单路径','图标','上级菜单','顺序','创建时间'],
					colModel:[
						{name: 'blank',index: '', width: 80,fixed: true,resize: false,
							formatter:authorityFormatter, //对列进行格式化时设置的函数名或者类型
							formatoptions:{ //formatoptions,对某些列进行格式化的设置
								keys:true,
								//当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。
								//如果设置多于一个，那么只选取第一个，其他被忽略
								
								delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback}
								//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
							}
						},
						{name:'id',index:'id',width:100, editable:false, sortable:true},
						{name:'mname',index:'mname',width:100, editable:true, sortable:true},
						{name:'mcode',index:'mcode', width:100,editable: true,sortable:false},
						{name:'url',index:'url', width:100,editable: true,sortable:false},
						{name:'icon',index:'icon', width:100, editable: true,sortable:false},
						{name:'pid',index:'pid', width:100, editable: true,sortable:false},
						{name:'order',index:'order', width:100, editable: true,sortable:false},
						{name:'createdTime',index:'createdTime',formatter:function(val,opt,cell){
							var s = "" ;
							var h = "" ;
							var m = "" ;
							m = val.minutes ;
							s = val.seconds ;
							return (val.year+1900)+"-"+(val.month+1)+"-"+val.date+" "+val.hours+":"+ m +":"+ s;
						}, width:100, editable: false,sortable:false}
					],
					
					viewrecords : true,//定义是否要显示总记录数
					rowNum:10,//在grid上显示记录条数，这个参数是要被传递到后台
					rowList:[10,20,30],//一个下拉选择框，用来改变显示记录数，当选择时会覆盖rowNum参数传递到后台
					pager : pager_selector,//定义翻页用的导航栏，必须是有效的html元素。翻页工具栏可以放置在html页面任意位置
					altRows: true,//设置表格 zebra-striped 值
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        loadComplete : function() {
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					editurl: "${contextPath}/sys/MenuAction/doOperate.com",//nothing is saved
					//caption: "jqGrid with inline editing",
					autowidth: true,
					gridComplete:function(){ 
						//在此事件中循环为每一行添加修改和删除链接
       					var ids=jQuery(grid_selector).jqGrid('getDataIDs'); 
       					for(var i=0; i<ids.length; i++){
	       					var id=ids[i]; 
	       					var rowData = $(grid_selector).jqGrid('getRowData',id);
	       					var rolno = rowData.id;
	       					modify ="<a href='#' style='color:#6A5ACD' onclick='Formatter(\""+rolno+"\")' class='btn btn-xs btn-warning'><i class='ace-icon fa fa-flag bigger-120'></i></a>"; //这里的onclick就是调用了上面的javascript函数 Modify(id) 
	       					jQuery(grid_selector).jqGrid('setRowData', ids[i], { rolno: modify}); 
       					} 
      				}
				});
				
				
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
								.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
					}, 0);
				}
				function authorityFormatter(cellvalue, options,cell) {
					var templatediv = "<div class='ui-pg-div ui-inline-edit'>";
						templatea ="<a title='打分' onclick='score()' style='text-decoration:none;' class='ui-icon ace-icon icon-pencil blue'></ a>"
						             +"<a title='查看详情' onclick='del()' style='text-decoration:none;' class='ui-icon icon-zoom-in grey'></ a>"
					var templatediv1 = "</div>";
					return templatediv+templatea+templatediv1;
				}
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
						edit: true,
						editicon : 'icon-pencil blue',
						add: true,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: true,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						view: true,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					},
					{
						//new record form
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					},
					{
						//delete record form
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							if(form.data('styled')) return false;
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							form.data('styled', true);
						},
						onClick : function(e) {
							alert(1);
						}
					},
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
				)
			
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').remove();
					buttons.eq(0).append('<i class="icon-chevron-left"></i>');
					buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
				}
				
				function beforeDeleteCallback(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
				function styleCheckbox(table) {
				
				}
				
				function updateActionIcons(table) {
				
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
				
				function styleCheckbox(table) {}
				
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
				
		});
	</script>
	</body>

</html>
