<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户管理</title>
    
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
  	<div id="query_div">
  		<table id="cx">
  			<tr>
  				<td>预约号查询:</td>
  				<td>
  					<input name="manke" style="width:100px" class="easyui-validatebox"  />
  				</td>
  				<td>　</td>
  				<td>姓名查询:</td>
  				<td>
  					<input name="e_name" style="width:100px" class="easyui-validatebox"  />
  				</td>
  				<td>　</td>
  				<td>电话查询:</td>
  				<td>
  					<input name="e_tel" style="width:100px" class="easyui-validatebox"  />
  				</td>
  				
  			</tr>
  			<tr>
  				<td>来源渠道查询:</td>
  				<td>
  					<select id="qd" name="ditch">
  						<option value="0">--请选择渠道--</option>
  					</select>
  				</td>
  				<td>　</td>
  				<td>咨询产品查询:</td>
  				<td>
  					<select id="product" name="product">
  						<option value="0">--请选择产品--</option>
  					</select>
  				</td>
  				<td>　</td>
  				<td>质询师查询:</td>
  				<td>
  					<select id="zxs" name="counselor" >
  						<option value="0">--请选择咨询师--</option>
  					</select>
  				</td>
  				<td>　</td>
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
    						<option value="男">男</option>
    						<option value="女">女</option>
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
    						<option selected="selected" value="YES">YES</option>
    						<option value="NO">NO</option>
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
  		    pageSize:5,
  		    pageList:[5,10,20],
  		    columns:[[ 
  		        { field:'ck',checkbox:true,width:60}, 
  		        { field:'id',title:'客服编号',hidden:true,width:60,align:"center"},
  		        { field:'manke',title:'预约号',width:100,align:"center"},
  		        { field:'e_name',title:'客户姓名',width:100,align:"center"},
  		        { field:'e_sex',title:'客户性别',width:100,align:"center"},
  		     	{ field:'e_tel',title:'客户电话',width:100,align:"center"},
  		        { field:'e_source',title:'客户来源',width:100,align:"center"},
	  		    { field:'QQ',title:'QQ',width:100,align:"center"},
	  		   	{ field:'consultProduct',title:'咨询产品',width:100,align:"center"},
	  		  	{ field:'counselor',title:'质询师',width:100,align:"center"},
	  			{ field:'turnover',title:'首次成交金额',width:100,align:"center"},
	  			{ field:'totalMoney',title:'总金额',width:100,align:"center"},
	  			{ field:'detailedAddress',title:'详细地址',width:100,align:"center"},
	  			{ field:'arrivalDate',title:'预计到店时间',width:100,align:"center"},
	  			{ field:'revisitDays',title:'预计回访时间',width:100,align:"center"},
	  			{ field:'dataState',hidden:true,title:'数据是否有效',width:100,align:"center"},
  			 ]]
  		});
  		//增加客户        渠道添加option节点
  		$.post('DisposeServlet?m=selectDitch',{},
	  		function (data){
	  			$('#ditch option:not(:first)').remove();
	  			for(var i in data){
	  				$("#ditch").append("<option value='"+data[i].ditchName+"'>"+data[i].ditchName+"</option>");
	  			}
	  		},'json');
  		//查询      上的渠道
  		$.post('DisposeServlet?m=selectDitch',{},
	  		function (data){
	  			$('#qd option:not(:first)').remove();
	  			for(var i in data){
	  				$("#qd").append("<option value='"+data[i].ditchName+"'>"+data[i].ditchName+"</option>");
	  			}
	  		},'json');
	  	//增加客户       上的产品信息
	  	$.post('DisposeServlet?m=selectProduct',{},
	  		function (data){
	  			$('#cp option:not(:first)').remove();
	  			for(var i in data){
	  				$("#cp").append("<option value='"+data[i].p_name+"'>"+data[i].p_name+"</option>");
	  			}
	  		},'json');
  		//查询       上select加载的产品
  			$.post('DisposeServlet?m=selectProduct',{},
	  		function (data){
	  			$('#product option:not(:first)').remove();
	  			for(var i in data){
	  				$("#product").append("<option value='"+data[i].p_name+"'>"+data[i].p_name+"</option>");
	  			}
	  		},'json');
  		//增加客户      异步加载咨询师
  		$.post('DisposeServlet?m=selectUser',{},
	  		function (data){
	  			$('#counselor option:not(:first)').remove();
	  			for(var i in data){
	  				$("#counselor").append("<option value='"+data[i].realName+"'>"+data[i].realName+"</option>");
	  			}
	  		},'json');
  		//查询上异步加载咨询师
  		$.post('DisposeServlet?m=selectUser',{},
	  		function (data){
	  			$('#zxs option:not(:first)').remove();
	  			for(var i in data){
	  				$("#zxs").append("<option value='"+data[i].realName+"'>"+data[i].realName+"</option>");
	  			}
	  		},'json');
  		//添加按钮
  		$('#dg').datagrid({
  			toolbar: [{
  				iconCls: 'icon-add',
  				text:'添加客户',
  				handler: function(){
  					$('#addElient').window('open');
  					
  				}
  			},'-',{
  				iconCls: 'icon-cancel',
  				text:'删除客户',
  				handler: function(){alert('帮助按钮')}
  			},'-',{
  				iconCls: 'icon-edit',
  				text:'修改客户',
  				handler: function(){alert('帮助按钮')}
  			},'-',{
  				iconCls: 'icon-edit',
  				text:'导出EXCEL',
  				handler: function(){
					
  				}
  			}

  			]
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
  // 向后抬提交增加客服的表单
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
    	    }    
    	});
    };

    function query(){
    	var manke = $('#query_div input[name="manke"]').val();
    	var e_name = $('#query_div input[name="e_name"]').val();
    	var e_tel = $('#query_div input[name="e_tel"]').val();
    	var ditch = $('#query_div select[name="ditch"]').val();
    	var product = $('#query_div select[name="product"]').val();
    	var counselor = $('#query_div select[name="counselor"]').val();//咨询师
    	var sql = "";
    	if(manke!=''){
			sql+=" and manke LIKE '%"+manke+"%'" ;
        }
        if(e_name!=''){
        	sql+=" and e_name LIKE '%"+e_name+"%'" ;
         }
        if(e_tel!=''){
			sql+=" and e_tel LIKE '%"+e_tel+"%'" ;
         }
         if(product!=''){
         	sql+=" and consultProduct '%"+product+"%'";
         }
         if(counselor!=''){
         	sql+=" and counselor '%"+counselor+"%'";
         }
        $("#dg").datagrid("load",{
			sql:sql,
		});
     }
  </script>
</html>
