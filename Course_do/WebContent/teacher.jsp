<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
	<style type="text/css">
		#body{
	    width: 100%;
	    height: 50%;
	    text-align: center;
		}
		img{
	    width: 200px;
	    height: 200px;
	    margin-top: 20px;
	    }
	    div{
	    	font-size:20px
	    }
	    span{
	    	margin-left:120px;
	    }
	    button{
	    	margin-left:730px;
	    }
	</style>
	<title>teacher</title>
</head>
<%
	String user = (String)session.getAttribute("user");
%>
<body>
		<div>&nbsp;</div>
		<div class="alert alert-info">
			<span id="teachername"><%=user %>老师您好</span>||<a href="logout.jsp">注销</a>
		</div>
		<div id="body"><img src="img/login.png"/></div>
		<br />
		<div>
			<button id="shenqing" class="btn btn-info" onclick="shenqing()">申请排课</button><br /><br />
			<button id="chakan" class="btn btn-info" onclick="chakan()">查看课表</button><br /><br />
			<button id="course" class="btn btn-info" onclick="course()">课程信息</button>
		</div>
	</body>
	<script type="text/javascript">
		function shenqing(){
			window.location.href="application.jsp";
		}
		function chakan(){
			window.location.href="look_1.jsp";
		}
		function course(){
			window.location.href="teachercourseinfomation.jsp";
		}
	</script>
</body>
</html>