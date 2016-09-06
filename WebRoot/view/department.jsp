<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门</title>
    
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
    				<td colspan="2"> <input type="hidden" name="d_eptno"/></td>
    			</tr>
	    		<tr>
	    			<td style="width:130px">部门名称：</td>
	    			<td><input name="d_name"  data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>部门主管ID</td>
	    			<td>
	    			<select  id="sel" name="manage_id" style="width:150px;">   
					    <option value="-1">--请选择--</option>   
					      
					</select> 
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>部门描述：</td>
	    			<td><input name="d_describe"  data-options="required:true" /></td>
	    		</tr>
	
	    		<tr>
    			<td>部门状态：</td>
	    			<td>
	    				<select name="deptState" class="easyui-combobox"  style="width:150px;">   
						    <option value="YES">YES</option>   
						    <option value="NO">NO</option>   
						</select> 
	    			</td>
    			</tr>
    			<tr>
	    			<td ><a id="btn_m" href="javascript:addDept()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> </td>
	    			<td ><input type="reset" value="重置"/></td>
    			</tr>
    		</table>
    	</form>
    </div>  

  </body>
  <script type="text/javascript">
  $('#dg').datagrid({    
	    url:'DisposeServlet?m=showDept',   
	    pagination:true, 
	    pageSize:5,
	    pageList:[5,10,20],
	    columns:[[ 
	        { field:'ck',checkbox:true,width:60}, 
	        { field:'d_eptno',title:'部门编号',hidden:true,width:60,align:"center"},
	        { field:'d_name',title:'部门名称',width:60,align:"center"},
	        { field:'manage_id',title:'部门主管ID',width:60,align:"center"},
	        { field:'d_describe',title:'部门描述',width:60,align:"center"},
	        { field:'deptState',title:'部门状态',width:60,align:"center"},
		 ]]
	});
  $('#dg').datagrid({
		toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				$('#win').window('open');
				//到后台查处所有用户动态生成下拉列表     选主管
				$.post('DisposeServlet?m=selectMange',{},
					function(data){
						$('#sel option:not(:first)').remove();
						for(var i in data){
							$('#sel').append('<option value="'+data[i].u_id+'">'+data[i].realName+'</option>');
						}
					},
					'json');
			}
		},'-',{
			iconCls: 'icon-cancel',
			text:'删除',
			handler: function(){alert('帮助按钮')}
		}]
	});
	//弹出添加部门的窗口
  $('#win').window({    
      width:400,    
      height:300,    
      modal:true,
      title:'添加渠道' ,
      closed:true,
      top:20, 
  }); 
  //提交添加部门信息到后台
  function addDept(){
	  $('#ff').form('submit', {    
		    url:'DisposeServlet?m=addDept',    
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
  }
  </script>
</html>
