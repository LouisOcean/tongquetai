<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单管理</title>
    
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
    <div id="win">
     	<form id="ff" method="post">
     	
    	<table>
	    		<tr>
	    			<td style="width:130px"></td>
	    			<td><input type="hidden" name="id"/></td>
	    		</tr>
	    		<tr>
	    			<td>菜单名称：</td>
	    			<td><input name="m_name" class="easyui-validatebox"  /></td>
	    		</tr>
	    		<tr>
	    			<td>菜单地址：</td>
	    			<td><input name="url" class="easyui-validatebox"  /></td>
	    		</tr>
	    		<tr>
	    			<td>菜单等级：</td>
	    			<td>
	    				<select id="level"  name="level" style="width:150px;">
	    					<option value="0">请选择菜单等级</option>
	    					<option value="1">一级菜单</option>
							<option value="2">二级菜单</option>  
						</select>
	    			</td>
	    		</tr>
	    		
	    		<tr id="p_menu" style="display: none">
	    			<td>父级菜单：</td>
	    			<td>
	    				<select id="parentMenu"  name="parent_id" style="width:150px;">
	    				</select>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td class="hasbtn" colspan="2">
		    			<a id="btn_m"  class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>  
		    			<a id="btn_reset" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a> 
	    			</td>
	    		</tr>
	    	</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$(function (){
  		$('#dg').datagrid({    
		    url:'DisposeServlet?m=showMenu', 
		    pagination:true,
		    pageSize:10,
		    pageList:[5,10],   
		    columns:[[ 
		        { field:'ck',checkbox:true,width:60}, 
		        { field:'id',title:'编号',hidden:false,width:60},
		        { field:'m_name',title:'菜单名称',width:60},
		        { field:'url',title:'地址',width:60},
		        { field:'parent_id',title:'父级菜单',hidden:true,width:60},
		 	]]
		 
	  });
		//添加功能按钮
  		$('#dg').datagrid({
  			toolbar: [{
  				iconCls: 'icon-edit',
  				text:'添加菜单',
  				handler: function(){
  					$('#win').window('open');
  				}
  			},'-',{
  				iconCls: 'icon-help',
  				text:'删除菜单',
  				handler: function(){
  						var selec = $('#dg').datagrid('getSelections');
				if(selec.length<=0){
					alert("没有选中行");
					return;
				}
				//定义一个数组 存放选中的id
				var array = new Array();
				for(var i in selec){
					array.push(selec[i].id);
				}
				//将数组对象转换成字符串
				var str = array.join(',');
				//ajax向后台提交数据
				$.get('DisposeServlet?m=deleteMenu',{ids:str},
						function(data){
							$('#dg').datagrid('reload');
						},
					'text')
  				}
  			}]
  		});

  		//弹出窗口
  		$('#win').window({    
  	        width:400,    
  	        height:300,    
  	        modal:true,
  	        title:'添加菜单' ,
  	        closed:true,
  	        top:20, 
  	    });

  	    //动态显示一级菜单
  		$("#level").change(function(){
  			var menu_level = $("#level option:selected").val();
  			$("#parentMenu option").remove();
  			if(menu_level==1||menu_level==0){
  				$("#parentMenu").append("<option value='-1' selected>没有父级菜单</option>");
  				$("#p_menu").css("display","none");
  			}else{
  				$("#p_menu").css("display","");
  				$.post('DisposeServlet?m=queryMenuParent',{},function(data){
  					for(var i in data){
  						$("#parentMenu").append("<option value='"+data[i].id+"'>"+data[i].m_name+"</option>");
  					}
  				},"json");
  			}
  			$('#win').window('refresh');
  		});
  	//增加菜单
  		$('#btn_m').click(function(){

  	  		
  		  $('#ff').form('submit', {    
  			    url:'DisposeServlet?m=addMenu',    
  			    onSubmit: function(){    
  				  	var isValid = $(this).form('validate');
  					return isValid;
  			    },    
  			    success:function(data){    
  			    	$('#win').window('close');
  	    	        $('#dg').datagrid('reload');  
  	    	        alert("添加成功");
  			    }    
  			});
  	  

  
  		});


  		
  });
  </script>
</html>
