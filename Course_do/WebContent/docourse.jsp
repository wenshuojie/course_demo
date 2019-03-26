<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
<script type="text/javascript"src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
 <script type="text/javascript">
		function back(){
			window.location.href="checkapplication.jsp";
		}
	</script>
<title>排课页面</title>
</head>
<body>
	<%
		String url = "jdbc:mysql://localhost/course_do_system";

		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement();

		String experimentid = request.getParameter("experimentid");
		String teacherid = request.getParameter("teacherid");
		String experimentname = request.getParameter("experimentname");
		String classid = request.getParameter("classid");//从url取值
		
		session.setAttribute("experimentname", experimentname);
		session.setAttribute("experimentid", experimentid);
		session.setAttribute("teacherid", teacherid);
		session.setAttribute("classid", classid);//排课界面要用
	%>
	<form action="docourse_" method="post">
		<div>&nbsp;</div>
		<div class="alert alert-info" style="text-align: center;">
			正在为<span style="color: red;"><%=experimentname%></span>排课
		</div>
		<div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">周次</span>
		<select class="form-control" id="week" name="week" style="width:500px;">
			<%
				for (int i = 1; i <= 18; i++) {
			%>
			<option value='<%=i%>'>第<%=i%>周
			</option>
			<%
				}
			%>
		</select>
		</div>
		<br>
		<div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">星期数</span>
		<select class="form-control" id="day" name="day" style="width:500px;">
			<%
				for (int i = 1; i <= 7; i++) {
			%>
			<option value='<%=i%>'>星期<%=i%></option>
			<%
				}
			%>
		</select>
		</div>
		<br>
		<div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">节次</span>
		<select class="form-control" id="time" name="time" style="width:500px;">
			<option value="1-2">1-2</option>
			<option value="3-4">3-4</option>
			<option value="6-7">6-7</option>
			<option value="8-9">8-9</option>
			<option value="10-11">10-11</option>
		</select>
		</div>
		<br>
		<div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">机房编号</span>
		<select class="form-control" id="roomid" name="roomid" style="width:500px;">
			<%
				String sql = "select * from room";
				ResultSet rs = st.executeQuery(sql);//机房编号结果集
				while (rs.next()) {
			%>
			<option value='<%=rs.getString("机房号")%>'><%=rs.getString("机房号")%></option>
			<%
				}
			%>
		</select>
		</div>
		<br>
		<div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">班级</span>
		
			<%
				String sql2 = "select * from class where 班级编号 = '"+classid+"'";
				ResultSet rs1 = st.executeQuery(sql2);
				while (rs1.next()) {
			%>
			<input style="width:500px;" type="text" class="form-control" id="classid" name="classid" disabled="disabled" value='<%=rs1.getString("班级编号")%> <%=rs1.getString("专业")%> <%=rs1.getString("年级")%>级<%=rs1.getString("班级")%>班'/>
			<%
				}
			%>
		
		</div>
		<br>
		<div>&nbsp;</div>
		<input type="submit" class="btn btn-default" style="margin-left:46%;width:130px;margin-top:10px;" value="排课"/>
	</form>
	<br/>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>