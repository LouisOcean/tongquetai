<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 跟踪进度表</title>
    
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
    <table id="dg"></table>
    <div id="win">
    	<form id="ff" method="post">
    		<table>
    			<tr>
    				<td colspan="2"> <input type="hidden" name="id"/></td>
    			</tr>
    			<tr>
    				<td>咨询师编号</td>
    				<td>
    					<select class="user_id" id="user_id" name="user_id">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>客户编号</td>
    				<td>
    					<select class="elient_id" id="elient_id" name="elient_id">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪进度</td>
    				<td>
    					<select class="progress" id="progress" name="progress">
    						<option value="初次咨询">初次咨询</option>
    						<option value="确定意向">确定意向</option>
    						<option value="已交预约金">已交预约金</option>
    						<option value="未成交" selected="selected">未成交</option>
    						<option value="已成交">已成交</option>
    						<option value="多次成交">多次成交</option>
    						<option value="无意向">无意向</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪信息</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="progressInfo" />
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪时间</td>
    				<td>
    					<input  name="trackingDate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;" />
    				</td>
    			</tr>
    			<tr>
    				<td>回访时间</td>
    				<td>
    					<input  name="returnDate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;" />
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<a href="javascript:addRecord()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> 
    					<input type="reset" value="重置"/>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div> 
    <div id="modify">
    	<form id="mm" method="post">
    		<table>
    			<tr>
    				<td colspan="2"> <input type="hidden" name="id"/></td>
    			</tr>
    			<tr>
    				<td>咨询师编号</td>
    				<td>
    					<select class="user_id" id="user_id" name="user_id">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>客户编号</td>
    				<td>
    					<select class="elient_id" id="elient_id" name="elient_id">
    						<option value="0">请选择</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪进度</td>
    				<td>
    					<select class="Mprogress" id="Mprogress" name="Mprogress">
    						<option value="初次咨询">初次咨询</option>
    						<option value="确定意向">确定意向</option>
    						<option value="已交预约金">已交预约金</option>
    						<option value="未成交" selected="selected">未成交</option>
    						<option value="已成交">已成交</option>
    						<option value="多次成交">多次成交</option>
    						<option value="无意向">无意向</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪信息</td>
    				<td>
    					<input type="text" class="easyui-validatebox" name="progressInfo" />
    				</td>
    			</tr>
    			<tr>
    				<td>跟踪时间</td>
    				<td>
    					<input  name="trackingDate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;" />
    				</td>
    			</tr>
    			<tr>
    				<td>回访时间</td>
    				<td>
    					<input  name="returnDate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;" />
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<a href="javascript:modifyRecord()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a> 
    					<input type="reset" value="重置"/>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$(function(){
  		$.post('DisposeServlet?m=selectCounselor',{},
	  		function (data){
	  			$('.user_id option:not(:first)').remove();
	  			for(var i in data){
	  				$(".user_id").append("<option value='"+data[i].u_id+"'>"+data[i].realName+"</option>");
	  			}
	  		},'json');
  		//增加记录  异步加载客户
  		$.post('DisposeServlet?m=selectElient',{},
	  		function (data){
	  			$('.elient_id option:not(:first)').remove();
	  			for(var i in data){
	  				$(".elient_id").append("<option value='"+data[i].id+"'>"+data[i].e_name+"</option>");
	  			}
	  		},'json');
  		$('#dg').datagrid({    
  			url:'DisposeServlet?m=showRecord',   
  		    pagination:true, 
  		    pageSize:5,
  		    pageList:[5,10,20],   
  		    columns:[[ 
				{ field:'ck',checkbox:true,width:60},   
  		        {field:'id',title:'编号',hidden:true,width:100},    
  		        {field:'user_id',title:'咨询师编号',width:100},    
  		        {field:'elient_id',title:'客户编号',width:100}, 
  		      	{field:'progress',title:'跟踪进度',width:100},    
		        {field:'progressInfo',title:'跟踪信息',width:100},    
		        {field:'trackingDate',title:'跟踪时间',width:100},
		        {field:'returnDate',title:'回访时间',width:100} 
  		    ]]    
  		});
//添加功能按钮
  		$('#dg').datagrid({
  			toolbar: [
	  		  	{
	  				iconCls: 'icon-add',
	  				text:'添加纪录',
	  				handler: function(){
						$('#win').window('open');
						//增加纪录      异步加载咨询师
				  		
	  				}
	  			},'-',{
	  				iconCls: 'icon-cancel',
	  				text:'删除记录',
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
						var ids = array.join(',');
						//ajax向后台提交数据
						$.get('DisposeServlet?m=deleteRecord',{id:ids},
								function(data){
									$('#dg').datagrid('reload');
								},
							'text')
	  				}
	  			},'-',{
	  				iconCls: 'icon-edit',
	  				text:'修改记录',
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
						var id = seles[0].id;
						//修改回填
						$.post('DisposeServlet?m=backfillRecord',{id:id},
								function(data){
									$('#mm').form('load',{
										id:data.id,
										user_id:data.user_id,
										elient_id:data.elient_id,
										Mprogress:data.progress,
										progressInfo:data.progressInfo,
										trackingDate:data.trackingDate,
										returnDate:data.returnDate
									});
									
								},'json')
	  				}
	  			}

  			]
  			
  		});
  		//弹出添加纪录的窗口
  		$('#win').window({    
  	      width:400,    
  	      height:300,    
  	      modal:true,
  	      title:'添加纪录' ,
  	      closed:true,
  	      top:20, 
  	  }); 
    	//弹出修改记录的窗口
  		$('#modify').window({    
    	      width:400,    
    	      height:300,    
    	      modal:true,
    	      title:'添加纪录' ,
    	      closed:true,
    	      top:20, 
    	  }); 

  	 });
  	function addRecord(){
  		$('#ff').form('submit', {    
    	    url:'DisposeServlet?m=addReeord',    
    	    onSubmit: function(){    
    		var isValid = $(this).form('validate');
				return isValid;
    	    },    
    	    success:function(data){
    	    	$('#addReeord').window('close');
    	        $('#dg').datagrid('reload');  
    	        alert("添加成功");
    	    }    
    	});
	};

	function modifyRecord(){
		$('#mm').form('submit', {    
    	    url:'DisposeServlet?m=modifyRecord',    
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
