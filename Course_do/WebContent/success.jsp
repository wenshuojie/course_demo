<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
<script type="text/javascript">
	function back(){
		window.location.href="login.jsp";
	}
</script>
<title>success</title>
</head>
<body>
<%
	String msg1 = (String)session.getAttribute("msg1");
%>
<div class="alert alert-success"><%=msg1 %></div>
<div class="btn btn-default" onclick="back()">返回登录</div>
</body>
</html>