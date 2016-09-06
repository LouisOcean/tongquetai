<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>重庆铜雀台客户关系管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
       	.dj{
			display: block;
			float: left;
			width: 80px;
			height: 35px;
			background-color: #ff9999;
			border-radius: 5px;
			color: white;
			margin-left: 20px;
			margin-top: 7px;
			padding-left: 3px;
			padding-top: 5px;
			padding-bottom: 8px;
		}
		.dj:hover {
			opacity: 0.7;
			cursor: pointer;
		}
		#bt{
			color: #ff9999;
		}
		#dlk{
			margin-left: 180px;
		}
		#mz{
			color: #ff9999;
		}
        </style>
  </head>
   <body background="img/3.jpg">
		<div style="margin-left: 130px;margin-top: 100px;">
			<form action="DisposeServlet?m=login" method="post">
				<h1 id="bt">重庆铜雀台美容整形医院客户关系管理平台</h1>
				<table id="dlk">
					<tr>
						<td><label id="mz">账户：</label></td>
						<td><input type="text" name="userName" placeholder="请输入账户";" /></td>
					</tr>
					<tr>
						<td><label id="mz">密码：</label></td>
						<td><input type="password" name="userPasw" placeholder="请输入密码";" /></td>
					</tr>
					<tr>
						<td colspan="3" style="text-align: center;">
						<input class="dj" type="submit" value="登陆"/>
						<input class="dj" type="reset" value="重置"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
