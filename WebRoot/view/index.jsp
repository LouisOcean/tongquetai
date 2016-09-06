<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 此为欢迎页面 -->
    <title>铜雀台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<!--需要导入的5个链接-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
	

	<style type="text/css">
		#cc{
			width:1200px;
			height:700px;
			margin: auto;
		}
		iframe{
			background-color: white;
			width: 100%;
			height: 100%;
			border-radius: 5px;
			border: none;
		}
	</style>
	  
	<script type="text/javascript">
		$(function(){
			$('#aa li').hover(
			function(){
				$(this).css("background-color","lavender");
				$(this).css("cursor","pointer");
			},
			function(){
				$(this).css("background-color","white");
			})
 		});
	</script>
  </head>
  <body>
    <div id="cc" class="easyui-layout" >   
	    <div data-options="region:'north',title:'铜雀台CRM管理中心',split:false" style="height:137px;">
	    	<img src="img/5.png">
	    </div>  
	    <div data-options="region:'west',split:false" style="width:200px;">
	    	<div id="aa" class="easyui-accordion" data-options="fit:true">
	    	 	<c:forEach items="${list}" var="l">
	    		<div title="${l.m_name }" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
			       	<c:forEach items="${l.submenu}" var="sub">
			       		<li name="${sub.url}">${sub.m_name }</li>
			       	</c:forEach>
			    </div>  
			    </c:forEach>	
	   		</div>      
		</div> 
		<div id="center"data-options="region:'center'" style="padding:5px;background:#eee;">
			<div id="tt" class="easyui-tabs" style="width:100%;height:100%;"></div> 
		</div> 
	</div> 
  </body>
  <script type="text/javascript">
  	$('#aa li').click(function(){
		var text = $(this).text();
		var url = $(this).attr("name");
		var isopen = $('#tt').tabs("exists",text);
		//判断是否已打开
		if(!isopen){
			$('#tt').tabs('add',{    
				title:text,    
				content:'<iframe src="'+url+'"></iframe>',    
				closable:true,
				fit:true   
			});
		}else{
			$('#tt').tabs("select",text);
			//获得指定的选项卡
				var tab = $('#tt').tabs("getSelected");
			//刷新选中的选项卡
			$('#tt').tabs("update",{
				tab:tab,
				options:{}
			});
			}
	});
  </script>
</html>
