<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户</title>
    
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
  	<div id="select">
  			<table id="cx">
  				<tr>
  					<td>真实姓名:</td>
  					<td>
  						<input name="realName" class="easyui-validatebox"  />
  					</td>
  					<td>员工号:</td>
  					<td>
  						<input name="job" class="easyui-validatebox"  />
  					</td>
  					<td>电话号码:</td>
  					<td>
  						<input name="tel" class="easyui-validatebox"  />
  					</td>
  					<td>
  						<a id="btn" href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
  					</td>
  				</tr>
  			</table>
  	</div>
  	<table id="dg"></table> 
    <div id="win">
    	<form  id="ff" method="post">
    	<table>
    		<tr>
    			<td style="width:130px">工号：</td>
    			<td><input name="job" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>用户名：</td>
    			<td><input name="userName" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input  name="userPasw" type="password" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>真实姓名：</td>
    			<td><input name="realName" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>联系电话：</td>
    			<td><input name="tel" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>头像：</td>
    			<td><input type="text" name="head" /></td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td><input name="email" class="easyui-textbox" data-options="validType:'email'" ></td>
    		</tr>
    		<tr>
    			<td>QQ：</td>
    			<td><input type="text" name="qq"/></td>
    		</tr>
    		<tr>
    			<td>微信：</td>
    			<td><input type="text" name="weChat"/></td>
    		</tr>
    		<tr>
    			<td>紧急联系人：</td>
    			<td><input type="text" name="urgency_name"/></td>
    		</tr>
    		<tr>
    			<td>紧急联系人电话：</td>
    			<td><input type="text" name="urgency_tel"/></td>
    		</tr>
    		<tr>
    			<td>所在部门号：</td>
    			<td>
    				<select id="cc" class="easyui-combobox" name="department_id" style="width:150px;">   
					    <option value="10">财务部</option>   
					    <option value="20">业务部</option>   
					    <option value="30">人事部</option>   
					</select> 
    			</td>
    		</tr>
    		<tr>
    			<td>入职时间：</td>
    			<td><input  name="hiredate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input> </td>
    		</tr>
    		<tr>
    			<td>是否有效：</td>
    			<td>
    				<select name="dataState" class="easyui-combobox" name="dept" style="width:150px;">   
					    <option value="YES">YES</option>   
					    <option value="NO">NO</option>   
					</select> 
    			</td>
    		</tr>
    		<tr>
    			<td>职位角色号：</td>
    			<td>
    				<select name="role_id" class="easyui-combobox" name="dept" style="width:150px;">   
					    <option value="1">经理</option>   
					    <option value="2">主管</option>   
					    <option value="3">美容咨询师</option>   
					</select> 
    			</td>
    		</tr>
    		
    		<tr>
    			<td ><a href="javascript:addUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a> </td>
    			<td ><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
    
    
    <!-- 用户修改 -->
    <div id="modify">
    	
    	<form  id="mm" method="post">
    	<table>
    		<tr>
    			<td colspan="2"> <input type="hidden" name="u_id"/></td>
    		</tr>
    		<tr>
    			<td style="width:130px">工号：</td>
    			<td><input name="job" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>用户名：</td>
    			<td><input name="userName" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input  name="userPasw" type="password" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>真实姓名：</td>
    			<td><input name="realName" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>联系电话：</td>
    			<td><input name="tel" class="easyui-validatebox" data-options="required:true" /></td>
    		</tr>
    		<tr>
    			<td>头像：</td>
    			<td><input type="text" name="head" /></td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td><input name="email" class="easyui-textbox" data-options="validType:'email'" ></td>
    		</tr>
    		<tr>
    			<td>QQ：</td>
    			<td><input type="text" name="qq"/></td>
    		</tr>
    		<tr>
    			<td>微信：</td>
    			<td><input type="text" name="weChat"/></td>
    		</tr>
    		<tr>
    			<td>紧急联系人：</td>
    			<td><input type="text" name="urgency_name"/></td>
    		</tr>
    		<tr>
    			<td>紧急联系人电话：</td>
    			<td><input type="text" name="urgency_tel"/></td>
    		</tr>
    		<tr>
    			<td>所在部门号：</td>
    			<td>
    				<select id="cc" class="easyui-combobox" name="department_id" style="width:150px;">   
					    <option value="10">财务部</option>   
					    <option value="20">业务部</option>   
					    <option value="30">人事部</option>   
					</select> 
    			</td>
    		</tr>
    		<tr>
    			<td>入职时间：</td>
    			<td><input  name="hiredate"  type= "text" class= "easyui-datebox" required ="required" style="width:150px;"> </input> </td>
    		</tr>
    		<tr>
    			<td>是否有效：</td>
    			<td>
    				<select name="dataState" class="easyui-combobox" name="dept" style="width:150px;">   
					    <option value="YES">YES</option>   
					    <option value="NO">NO</option>   
					</select> 
    			</td>
    		</tr>
    		<tr>
    			<td>职位角色号：</td>
    			<td>
    				<select name="role_id" class="easyui-combobox" name="dept" style="width:150px;">   
					    <option value="1">经理</option>   
					    <option value="2">主管</option>   
					    <option value="3">美容咨询师</option>   
					</select> 
    			</td>
    		</tr>
    		
    		<tr>
    			<td ><a id="btn_m" href="javascript:modifyUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a> </td>
    			<td ><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
  
  <script type="text/javascript">
	$('#dg').datagrid({    
	    url:'DisposeServlet?m=checkUser',   
	    pagination:true,
	    //每页显示几条
	    pageSize:5, 
	    pageList:[5,10,15],
	    columns:[[ 
	        { field:'ck',checkbox:true,width:60},  
	        {	 field:'u_id',title:'用户编号',hidden:true },
	            
	        {	 field:'job',title:'员工号' }, 
		       
	        {	field:'userName', title:'用户名',width:60,align:"center"},
		       
		    { field:'userPasw',title:'密码', width:60, align:"center" } ,
		    { field:'realName',title:'真实姓名', width:60, align:"center" } ,
		      
		    {	 field:'tel', title:'用户电话', width:60, align:"center" } ,
		      
		    {	 field:'userHead', title:'用户头像', width:60, align:"center" } , 
		     
		    {	 field:'email', title:'邮箱', width:60,align:"center" } , 
		     
		    {	 field:'QQ',title:'QQ', width:60, align:"center" } ,

		    {	 field:'weChat', title:'微信', width:60,align:"center" }  ,
		     
		    {	 field:'urgency_name', title:'紧急联系人', width:60, align:"center"} ,
		      
		    {	 field:'urgency_tel', title:'紧急联系人电话',width:60,align:"center" } ,
		      
		    {	 field:'department_id', title:'部门编号', width:60, align:"center"} , 
		    
		     
		    {	field:'hiredate', title:'入职时间', width:60, align:"center" } ,
		      
		    {	 field:'dataState', title:'数据是否有效',hidden:true, width:60,align:"center" },  
		     
		    {	 field:'role_id', title:'职位角色ID', width:60, align:"center" }
		    
	    ]]

	    
	       
	});
	
	//添加工具栏按钮
	$('#dg').datagrid({
		toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				$('#win').window('open');
			}
		},'-',{
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
					array.push(selec[i].u_id);
				}
				//将数组对象转换成字符串
				var str = array.join(',');
				//ajax向后台提交数据
				$.get('DisposeServlet?m=deleteUser',{ids:str},
						function(data){
							$('#dg').datagrid('reload');
						},
					'text')
			}
		},'-',{
			iconCls: 'icon-pencil',
			text:'修改',
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
				var id = seles[0].u_id;
				$.post('DisposeServlet?m=backfill',{id:id},
						function(data){
							//数据回填
							$('#mm').form('load',{
								u_id:data.u_id,
								job:data.job,
								userName:data.userName,
								userPasw:data.userPasw,
								realName:data.realName,
								tel:data.tel,
								head:data.userHead,
								email:data.email,
								qq:data.QQ,
								weChat:data.weChat,
								urgency_name:data.urgency_name,
								urgency_tel:data.urgency_tel,
								department_id:data.department_id,
								hiredate:data.hiredate,
								dataState:data.dataState,
								role_id:data.role_id
							});
						},
						
						'json');
						
			}
		}]

		 
	});
	//添加弹出窗口
	$('#win').window({    
        width:600,    
        height:400,    
        modal:true,
        title:'添加用户' ,
        closed:true,
        top:20, 
    }); 
	//弹出修改用户的窗口
	$('#modify').window({    
			width:600,    
	        height:400,    
	        modal:true,
	        title:'修改用户' ,
	        closed:true,
	        top:20, 
    }); 
	//提交增加用户填写的信息到后台
	    function addUser(){
	    	$('#ff').form('submit', {    
	    	    url:'DisposeServlet?m=addUser',    
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
		//提交用户修改的信息到后台
		function modifyUser(){
			$('#mm').form('submit', {    
	    	    url:'DisposeServlet?m=modifyUser',    
	    	    onSubmit: function(){    
	    		var isValid = $(this).form('validate');
					return isValid;
	    	    }, 
	    	    //成功之后做的事   
	    	    success:function(data){
	    	    	$('#modify').window('close');
	    	        $('#dg').datagrid('reload');  
	    	        alert("修改成功");
	    	    }    
	    	});
		}

		function query(){
			var realName = $('#select input[name="realName"]').val();
			var job = $('#select input[name="job"]').val();
			var tel = $('#select input[name="tel"]').val();
			var sql = "";
			if(realName!=''){
				sql+=" and realName LIKE '%"+realName+"%'" ;
			}
			 if(job!=''){
				 sql+=" and job  LIKE '%"+job+"%'" ;
			}
			 if(tel!=''){
				 sql+=" and tel  LIKE '%"+tel+"%'" ;
			}
			 $("#dg").datagrid("load",{
					sql:sql,
				});
		}
		
	</script>
</html>
