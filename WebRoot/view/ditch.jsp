<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>渠道信息</title>
    
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
   <!-- 添加渠道弹窗 -->
   <div id="win">
   		<form id="ff" method="post">
   			<table>
   				<tr>
    				<td colspan="2"> <input type="hidden" name="ditch_id"/></td>
    			</tr>
	    		<tr>
	    			<td style="width:130px">渠道信息：</td>
	    			<td><input name="ditchInfo" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>渠道名称：</td>
	    			<td><input name="ditchName" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>成本：</td>
	    			<td><input name="cost" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>开始时间：</td>
	    			<td><input  name="beginTime"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input> </td>
    			</tr>
	    		<tr>
    			<td>是否有效：</td>
    			<td>
    				<select name="ditchState" class="easyui-combobox"  style="width:150px;">   
					    <option value="YES">YES</option>   
					    <option value="NO">NO</option>   
					</select> 
    			</td>
    			</tr>
	    		<tr>
	    			<td ><a id="btn_m" href="javascript:addDitch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> </td>
	    			<td ><input type="reset" value="重置"/></td>
    			</tr>
   				
   			</table>
   		</form>
   </div> 
   
   <!-- 修改弹出的窗口
   <div id="up">
   		<form id="upditch" method="post">
   			<table>
   				<tr>
    				<td colspan="2"> <input type="hidden" name="ditch_id"/></td>
    				<td>渠道编号</td>
    			</tr>
	    		<tr>
	    			<td style="width:130px">渠道信息：</td>
	    			<td><input name="ditchInfo" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>渠道名称：</td>
	    			<td><input name="ditchName" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>成本：</td>
	    			<td><input name="cost" class="easyui-validatebox" data-options="required:true" /></td>
	    		</tr>
	    		<tr>
	    			<td>开始时间：</td>
	    			<td><input  name="beginTime"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input> </td>
    			</tr>
	    		<tr>
    			<td>是否有效：</td>
    			<td>
    				<select name="ditchState" class="easyui-combobox" style="width:150px;">   
					    <option value="YES">YES</option>   
					    <option value="NO">NO</option>   
					</select> 
    			</td>
    			</tr>
	    		<tr>
	    			<td ><a id="btn_m" href="javascript:modifyDitch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> </td>
	    			<td ><input type="reset" value="重置"/></td>
    			</tr>
   				
   			</table>
   		</form>
   </div> 
   -->
  </body>
  <script type="text/javascript">
  //动态添加数据表格
  $('#dg').datagrid({    
	    url:'DisposeServlet?m=showDitch', 
	    pagination:true,
	    pageSize:5,
	    pageList:[5,10],   
	    columns:[[ 
	        { field:'ck',checkbox:true,width:60}, 
	        { field:'ditch_id',title:'渠道编号',hidden:true,width:60,align:"center"},
	        { field:'ditchInfo',title:'渠道信息',width:60,align:"center"},
	        { field:'ditchName',title:'渠道名',width:60,align:"center"},
	        { field:'cost',title:'成本',width:60,align:"center"},
	        { field:'beginTime',title:'渠道开始时间',width:60,align:"center"},
	        { field:'ditchState',title:'是否有效',width:60,align:"center"},
	 ]]
  });
	//向数据表格中添加按钮
  $('#dg').datagrid({
		toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
			$('#win').window('open');
			}
		},{
			iconCls: 'icon-cancel',
			text:'删除',
			handler: function(){
				var selec = $('#dg').datagrid('getSelections');
				if(selec.length<=0){
					alert("没有选中行");
					return;
				}
				
				//定义一个数组 存放选中的id
				var array = new Array();
				for(var i in selec){
					array.push(selec[i].ditch_id);
				}
				//将数组对象转换成字符串
				var str = array.join(',');
				//ajax向后台提交数据
				$.get('DisposeServlet?m=delecteDitch',{ids:str},
						function(data){
							$('#dg').datagrid('reload');
						},
					'text')
				}
			
				
		},/*{
			iconCls: 'icon-pencil',
			text:'修改',
			handler: function(){
				$('#up').window('open');
				var seles = $('#dg').datagrid('getSelections');
				if(seles.length<=0){
					alert('没有选中要修改的行');
					return;
				}
				if(seles.length>1){
					alert('不能一次修改多行');
					return;
				}
				var ditch_id = seles[0].ditch_id;
				//表单回填
				$.post('DisposeServlet?m=selectDitch',{ditchid:ditch_id},
					function(data){
						$('#upditch').form('load',{
							ditch_id:data.ditch_id,
							ditchInfo:data.ditchInfo,
							ditchName:data.ditchName,
							cost:data.cost,
							beginTime:data.beginTime,
							ditchState:data.ditchState
						});


					},'josn');
			}
		},*/{
			iconCls: 'icon-search',
			text:'查询',
			handler: function(){}
		}

		]
  });
	//添加渠道弹出窗口
  $('#win').window({    
      width:400,    
      height:300,    
      modal:true,
      title:'添加渠道' ,
      closed:true,
      top:20, 
  }); 
  
 
  //添加渠道的表单提交
  function addDitch(){
	  
	  $('#ff').form('submit', {    
		    url:'DisposeServlet?m=addDitch',    
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
   //弹出修改的窗口
  $('#up').window({    
      width:400,    
      height:300,    
      modal:true,
      title:'修改渠道' ,
      closed:true,
      top:20, 
  }); 
  //提交修改之后的渠道信息
  function modifyDitch(){
  	$('#upditch').form('submit', {    
	    	    url:'DisposeServlet?m=modifyDitch',    
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
