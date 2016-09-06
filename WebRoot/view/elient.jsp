<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.5/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

  </head>
  
  <body>
  	<div id="select">
  		<table>
  			<tr>
  				<td>客户姓名:</td>
  				<td>
  					<input name="e_name" class="easyui-validatebox" style="width:100px" />
  				</td>
  				<td>　</td>
  				<td>咨询产品:</td>
  				<td>
  					<input name="product" class="easyui-validatebox"  style="width:100px" />
  				</td>
  				<td>　</td>
  				<td>到店时间</td>
  				<td>
  					<input  name="arrivalDate"  type= "text" class= "easyui-datebox" style="width:100px"/>
  				</td>
  				<td>　</td>
  				<td>致</td>
  				<td>
  					<input  name="arrivalDate1"  type= "text" class= "easyui-datebox" style="width:100px"/>
  				</td>
  				<td>
  					<a id="btn" href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
  				</td>
  			</tr>
  		</table>
  	</div>
  	<table id="dg"></table>
    <div id="addElient">
    	<form  id="ff" method="post">
    		<table>
    			<tr>
    				<td colspan="2"> <input type="hidden" name="id"/></td>
    			</tr>
    			<tr>
    				<td>预约号:</td>
    				<td>
    					<input type="text" class="easyui-validatebox"  name="manke" />
    				</td>
    			</tr>
    			<tr>
    				<td>客户姓名:</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="e_name" />
    				</td>
    			
    			</tr>
    			<tr>
    				<td>客服性别:</td>
    				<td>
    					<select id="sex" name="e_sex">
    						<option value="1">男</option>
    						<option value="2">女</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>客户电话:</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="e_tel" />
    				</td>
    			</tr>
    			<tr>
    				<td>来寻渠道:</td>
    				<td>
    					<select id="ditch" name="e_source">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>QQ:</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="QQ" />
    				</td>
    			</tr>
    			<tr>
    				<td>咨询产品:</td>
    				<td>
    					<select id="cp" name="consultProduct">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>咨询师</td>
    				<td>
    					<select id="counselor" name="counselor">
    						<option value="0" selected="selected">自己</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>首次成交金额：</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="turnover" />
    				</td>
    			</tr>
    			<tr>
    				<td>总金额：</td>
					<td>
						<input type="text" class="easyui-validatebox" name="totalMoney" />
					</td>
    			</tr>
    			<tr>
    				<td>详细地址：</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="detailedAddress" />
    				</td>
    			</tr>
    			<tr>
    				<td>预计到店时间：</td>
    				<td>
    					<input  name="arrivalDate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input>
    				</td>
    			</tr>
    			<tr>
    				<td>预计回访时间：</td>
    				<td>
    					<input  name="revisitDays"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input>
    				</td>
    			</tr>
    			<tr>
    				<td>数据是否有效</td>
    				<td>
    					<select id="data" name="data">
    						<option value="YES" selected="selected">YES</option>
    						<option value="NO" >NO</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<a href="javascript:addElient()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> 
    					<input type="reset" value="重置"/>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$(function(){
  		$('#dg').datagrid({    
  		    url:'DisposeServlet?m=showElient',   
  		  	pagination:true,
  	    //每页显示几条
  	   		pageSize:10, 
  	    	pageList:[5,10,15],
  		    columns:[[ 
  		        { field:'ck',checkbox:true,width:60}, 
  		        { field:'id',title:'客服编号',hidden:true,width:60,align:"center"},
  		        { field:'manke',title:'预约号',width:100,align:"center"},
  		        { field:'e_name',title:'客户姓名',width:100,align:"center"},
  		        { field:'e_sex',title:'客户性别',width:100,align:"center"},
  		        { field:'e_source',title:'客户来源',width:100,align:"center"},
	  		    { field:'QQ',title:'QQ',width:100,align:"center"},
	  		   	{ field:'consultProduct',title:'咨询产品',width:100,align:"center"},
	  		  	{ field:'counselor',title:'质询师',width:100,align:"center"},
	  			{ field:'turnover',title:'首次成交金额',width:100,align:"center"},
	  			{ field:'totalMoney',title:'总金额',width:100,align:"center"},
	  			{ field:'detailedAddress',title:'详细地址',width:100,align:"center"},
	  			{ field:'arrivalDate',title:'预计到店时间',width:100,align:"center"},
	  			{ field:'revisitDays',title:'预计回访时间',width:100,align:"center"},
	  			{ field:'dataState',title:'是否有效数据',width:100,align:"center"},
  			 ]]
  		});
  		//查询渠道添加option节点
  		$.post('DisposeServlet?m=selectDitch',{},
	  		function (data){
	  			$('#ditch option:not(:first)').remove();
	  			for(var i in data){
	  				$("#ditch").append("<option value='"+data[i].ditchName+"'>"+data[i].ditchName+"</option>");
	  			}
	  		},'json');
	  	//查询产品信息
	  	$.post('DisposeServlet?m=selectProduct',{},
	  		function (data){
	  			$('#cp option:not(:first)').remove();
	  			for(var i in data){
	  				$("#cp").append("<option value='"+data[i].p_name+"'>"+data[i].p_name+"</option>");
	  			}
	  		},'json');
  		//异步加载咨询师
  		$.post('DisposeServlet?m=selectUser',{},
	  		function (data){
	  			$('#counselor option:not(:first)').remove();
	  			for(var i in data){
	  				$("#counselor").append("<option value='"+data[i].realName+"'>"+data[i].realName+"</option>");
	  			}
	  		},'json');
  		//添加按钮
  		$('#dg').datagrid({
  			toolbar: [{
  				iconCls: 'icon-edit',
  				text:'添加用户',
  				handler: function(){
  					$('#addElient').window('open');
  					
  				}
  			},'-',{
  				iconCls: 'icon-help',
  				text:'删除客户',
  				handler: function(){alert('帮助按钮')}
  			}]
  		});
	//弹出添加客户的窗口
  		$('#addElient').window({    
  	      width:600,    
  	      height:400,    
  	      modal:true,
  	      title:'添加客户' ,
  	      closed:true,
  	      top:20, 
  	  });
   
  		  		
  });
  
   function addElient(){
    	$('#ff').form('submit', {    
    	    url:'DisposeServlet?m=addElient',    
    	    onSubmit: function(){    
    		var isValid = $(this).form('validate');
				return isValid;
    	    },    
    	    success:function(data){
    	    	$('#addElient').window('close');
    	        $('#dg').datagrid('reload');  
    	        alert("添加成功");
    	    }    
    	});
    };

    function query(){
    	var e_name = $('#select input[name="e_name"]').val();
    	var product = $('#select input[name="product"]').val();
    	var arrivalDate = $('#select input[name="arrivalDate"]').val();
    	var arrivalDate1 = $('#select input[name="arrivalDate1"]').val();
    	var sql = "";
    	if(e_name!=""){
			sql+=" and e_name LIKE '%"+e_name+"%'" ;
        }
        if(product!=""){
        	sql+=" and consultProduct LIKE '%"+product+"%'" ;
        }
        if(arrivalDate=""){
        	sql+=" and consultProduct LIKE '%"+product+"%'" ;	
        }
        if(arrivalDate1)
        $("#dg").datagrid("load",{
			sql:sql,
		});
     }
  </script>
</html>
