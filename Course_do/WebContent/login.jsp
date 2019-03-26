<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
		<script type="application/javascript">
			
			function check(){
				var userid=document.getElementById("userid").value;
				if(userid.length!=12){
					document.getElementById("inf").innerHTML="<font style='color: red;'>请输入十二位账号</font>";
				}
				else{
					document.getElementById("inf").innerHTML="<font style='color: green;'>格式正确</font>";
				}
			}
			
		</script>
		<link rel="stylesheet" type="text/css" href="login.css">
		<meta charset="utf-8">
		<title>用户登录界面</title>
<div  class="alert alert-info" style="text-align: center;font-size: 25px;">人工排课系统</div>
		
		<div id="body"><img src="img/login.png"/></div>
		<div class="line">&nbsp;</div>
		<div id="foot">
				<form action="login_" method="post">
					<div class="input-group input-group-lg" style="margin-left: 31%;">
					<span class="input-group-addon">账号</span>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="请输入账号" onkeyup="check()"/>
					</div>
					<br/>
					<div><span id="inf"></span></div>
					<br/>
					<div class="input-group input-group-lg" style="margin-left: 31%;">
					<span class="input-group-addon">密码</span>
					<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
					</div>
					<br />
					<input type="submit" class="btn btn-default" id="sub" value="登录"/>
				</form>				
		</div>
		<div class="line">&nbsp;</div>
		<div id="last"><a href="regist.jsp">教师注册</a></div>
</body>
</html>
