<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>产品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		<!--需要导入的5个链接-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
    <table id ="dg"></table>
    <div id="win">
    	<form id="ff" method="post">
    		<table>
    			<tr>
    				<td colspan="2"> <input type="hidden" name="p_id"/></td>
    			</tr>
    			<tr>
    				<td>产品名称:</td>
    				<td><input type="text" name="p_name" data-options="required:true" /></td>
    			</tr>
    			<tr>
    				<td>推荐医生:</td>
    				<td><input type="text" name="recommendDoctor" /></td>
    			</tr>
    			<tr>
    				<td>产品描述:</td>
    				<td>
    					<input type="text" name="p_describe" />
    				</td>
    			</tr>
    			<tr>
    				<td>创建时间:</td>
    				<td><input  name="createTime"  type= "text" class= "easyui-datebox" required ="required" style="width:100px;"></td>
    			</tr>
    			<tr>
    				<td>产品是否有效:</td>
    				<td>
    					<select name="p_state" class="easyui-combobox"  style="width:150px;">   
						    <option value="YES">YES</option>   
						    <option value="NO">NO</option>   
						</select>
    				</td>
    			</tr>
    			<tr>
    				<td><a href="javascript:addProduct()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">提交</a> </td>
    				<td><input type="reset" value="重置" />
    			</tr>
    			
    		</table>
    	</form>
    </div>
    
    <!-- 修改产品 -->
    <div id="modify">
    	<form id="mm" method="post">
    		<table>
    			<tr>
    				<td colspan="2"> <input type="hidden" name="p_id"/></td>
    			</tr>
    			<tr>
    				<td>产品名称:</td>
    				<td><input type="text" name="p_name" data-options="required:true" /></td>
    			</tr>
    			<tr>
    				<td>推荐医生:</td>
    				<td><input type="text" name="recommendDoctor" /></td>
    			</tr>
    			<tr>
    				<td>产品描述:</td>
    				<td>
    					<input type="text" name="p_describe" />
    				</td>
    			</tr>
    			<tr>
    				<td>创建时间:</td>
    				<td><input  name="createTime"  type= "text" class= "easyui-datebox" required ="required" style="width:100px;"></td>
    			</tr>
    			<tr>
    				<td>产品是否有效:</td>
    				<td>
    					<select name="p_state" class="easyui-combobox"  style="width:150px;">   
						    <option value="YES">YES</option>   
						    <option value="NO">NO</option>   
						</select>
    				</td>
    			</tr>
    			<tr>
    				<td><a href="javascript:modifyProduct()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">提交</a> </td>
    				<td><input type="reset" value="重置" />
    			</tr>
    			
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  $('#dg').datagrid({    
	    url:'DisposeServlet?m=showProduct',  
	    pagination:true,
	    //每页显示几条
	    pageSize:5, 
	    pageList:[5,10,15],  
	    columns:[[ 
	        { field:'ck',checkbox:true,width:60}, 
	        { field:'p_id',title:'产品编号',hidden:true,width:60,align:"center"},
	        { field:'p_name',title:'产品名称',width:60,align:"center"},
	        { field:'recommendDoctor',title:'推荐医生',width:60,align:"center"},
	        { field:'p_describe',title:'产品描述',width:60,align:"center"},
	        { field:'createTime',title:'创建时间',width:60,align:"center"},
	        { field:'p_state',title:'是否有效',width:60,align:"center"},
		 ]]
	});
  $('#dg').datagrid({
	  toolbar: [{
			iconCls: 'icon-add',
			text:'添加产品',
			handler: function(){
		  		$('#win').window('open');  
			}
		},'-',{
			iconCls: 'icon-cancel',
			text:'删除产品',
			handler: function(){
				var selec = $('#dg').datagrid('getSelections');
				if(selec.length<=0){
					alert("没有选中行");
					return;
				}
				//定义一个数组 存放选中的id
				var array = new Array();
				for(var i in selec){
					array.push(selec[i].p_id);
				}
				//将数组对象转换成字符串
				var p_id = array.join(',');
				$.get('DisposeServlet?m=deleteProduct',{ids:p_id},
						function(data){
							$('#dg').datagrid('reload');
						},
					'text')
			}
		},'-',{
			iconCls: 'icon-pencil',
			text:'修改产品',
			handler: function(){
				var seles = $('#dg').datagrid('getSelections');
				if(seles.length<=0){
					alert('没有选中要修改的行');
					return;
				}
				if(seles.length>1){
					alert('不能一次修改多行');
					return;
				}
				$('#modify').window('open');
				var p_id = seles[0].p_id;
				//响应回来的data参数           表单回填
				$.post("DisposeServlet?m=backfillProduct",{p_id:p_id},
						function(data){
							$('#mm').form('load',{
								p_id:data.p_id,
								p_name:data.p_name,
								recommendDoctor:data.recommendDoctor,
								p_describe:data.p_describe,
								createTime:data.createTime,
								p_state:data.p_state
							});
						},'json');
					
			}
		},'-',{
			iconCls: 'icon-search',
			text:'查询产品',
			handler: function(){}
		}

	  ]
		

	});
	//弹出添加产品窗口
  $('#win').window({    
	    width:400,    
	    height:300,    
	    modal:true,
	    title:'添加产品' ,
	    closed:true,
	    top:20,  
	});  
	//弹出修改产品的窗口
	$('#modify').window({    
	    width:400,    
	    height:300,    
	    modal:true,
	    title:'修改产品' ,
	    closed:true,
	    top:20,  
	}); 
	//向后台提交添加产品信息
	function addProduct(){
		$('#ff').form('submit', {    
		    url:'DisposeServlet?m=addProduct',    
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
					
	};
//向后台提交修改的产品信息
	function modifyProduct(){
		$('#mm').form('submit', {    
			    url:'DisposeServlet?m=modifyProduct',    
			    onSubmit: function(){    
					var isValid = $(this).form('validate');
					return isValid;  
			    },    
			    success:function(data){    
			    	$('#modify').window('close');
	    	        $('#dg').datagrid('reload');  
	    	        alert("修改成功");    
			    } 
		});   
	}
  </script>
</html>
