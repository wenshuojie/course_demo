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
	   table{
	   	margin-left:500px;
	   }
	</style>
	<title>teacher</title>
</head>
<%
	String user = (String)session.getAttribute("user");
%>
<body>
		<div>&nbsp;</div>
		<div class="alert alert-warning">
			<span id="teachername"><%=user %>管理员您好</span>||<a href="logout.jsp">注销</a>
		</div>
		<div id="body"><img src="img/login.png"/></div>
		<br />
		<table>
	<tr>
		<td><button id="shenqing" class="btn btn-info" onclick="shenqing()">查看申请</button>&nbsp;&nbsp;</td>
		<td><button id="chakan" class="btn btn-info" onclick="chakan()">查看实验</button>&nbsp;&nbsp;</td>
		<td><button id="course" class="btn btn-info" onclick="course()">课程信息</button>&nbsp;&nbsp;</td>
		<td><button id="roominfomation" class="btn btn-info" onclick="roominfomation()">机房信息</button>&nbsp;&nbsp;</td>
		<td><button id="classinfomation" class="btn btn-info" onclick="classinfomation()">班级信息</button>&nbsp;&nbsp;</td>
		<td><button id="teacherinfomation" class="btn btn-info" onclick="teacherinfomation()">教师信息</button></td>
	</tr>
</table>
	</body>
	<script type="text/javascript">
		function shenqing(){
			window.location.href="checkapplication.jsp";
		}
		function chakan(){
			window.location.href="look_2.jsp";
		}
		function roominfomation(){
			window.location.href="roominfomation.jsp";
		}
		function classinfomation(){
			window.location.href="classinfomation.jsp";
		}
		function teacherinfomation(){
			window.location.href="teacherinfomation.jsp";
		}
		function course(){
			window.location.href="courseinfomation.jsp";
		}
	</script>
</body>
</html>