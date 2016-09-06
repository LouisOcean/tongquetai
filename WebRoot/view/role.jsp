<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<!--需要导入的5个链接-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
 	
  </head>
  
  <body>
  	<table id="dg"></table>
  	<div id="update_div">
    		<form id="updateSource" method="post">
    			
    		</form>
    		<p style="text-align:center">
	    		<a id="btn" href="javascript:updateRights()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
	    		<a id="btn" href="javascript:resetRights()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a>
    		</p>
    	</div>
  </body>
  <script type="text/javascript">
	$(function (){
		$('#dg').datagrid({    
		    url:'DisposeServlet?m=showRole',
		    pagination:true,
		    pageSize:5,
		    pageList:[5,10],      
		    columns:[[    
		        { field:'ck',checkbox:true,width:60},    
		        {field:'id',title:'角色编号',width:100},    
		        {field:'roleName',title:'角色名',width:100,align:'right'}    
		    ]],
		       
		});
		//添加按钮
		$('#dg').datagrid({
			toolbar: [{
				iconCls: 'icon-edit',
				text:'修改权限',
				handler: function(){
					var select=$("#dg").datagrid("getSelections");
					if(select.length>1){
						alert("只能一次修改一个职位!");
						return;
					}
					if(select.length<=0){
						alert("请选择职位修改!");
						return;
					}
					$('#update_div').window('open');
					var id=select[0].id;
					//添加之前删除from下原来的input
					$('#updateSource').children().remove();
					$('#updateSource').text("");	
					$('#updateSource').append('<input type="hidden" id="RoleId" value='+id+'>');
					$.post("DisposeServlet?m=selectMenu",{id:id},function(data){
						for(var i in data){
							$('#updateSource').append('<input type="checkbox" '+(data[i].r_id!=0?'checked':'')+' name="quanXian" value='+data[i].id+'>'+'<span class="firstName">'+data[i].m_name+'</span><br/>');
							var submenu=data[i].submenu;
							for(var j in submenu){
								$('#updateSource').append('<input type="checkbox" '+(submenu[j].r_id!=0?'checked':'')+' name="quanXian" value='+submenu[j].id+'>'+'<span class="secondName">'+submenu[j].m_name+'</span><br/>');	
							}
						}		
					},"json");







					
				}
			}]
		});
		$('#update_div').window({    
		    width:350,    
		    height:610,    
		    modal:true,
		    closed:true,
			top:10,
			title:"修改职位权限"
		});
		

	

		       
	});
		 
  </script>
</html>
