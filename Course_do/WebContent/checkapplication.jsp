<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
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
			window.location.href="admin.jsp";
		}
	</script>
<title>checkapplication</title>
</head>
<body>
<%
	String url = "jdbc:mysql://localhost/course_do_system";
	String sql1 = "select * from course";
	String sql2 = "select * from experiment order by 实验项目编号";
	//String sql3 = "select * from teacher";

	Class.forName("com.mysql.jdbc.Driver");// 加载驱动
	Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
	Statement st1 = con.createStatement(); //执行课程表sql语句
	Statement st2 = con.createStatement(); //执行实验表sql语句
	//Statement st3 = con.createStatement(); //执行教师表sql语句	
	ResultSet rs1 = st1.executeQuery(sql1); //课程表
	ResultSet rs2 = st2.executeQuery(sql2);	//实验表
	//ResultSet rs3 = st3.executeQuery(sql3); //教师表	
%>
	<table class="table">
			<thead>
			      <tr>
			         <th>课程号</th>
			         <th>课程名</th>
			         <th>实验号</th>
			         <th>实验名</th>
			         <th>总学时</th>
			         <th>实验学时</th>
			         <th>任课教师编号</th>
			         <th>班级编号</th>
			         <th>排课</th>
			         <th>取消排课</th>
			      </tr>
   			</thead>
   			<tbody>

<%
	while(rs1.next()&&rs2.next()){
%>
				<tr>
					<td><%=rs1.getString("课程号") %></td>
					<td><%=rs1.getString("课程名") %></td>
					<td><%=rs2.getString("实验项目编号") %></td>
					<td><%=rs2.getString("名称") %></td>
					<td><%=rs1.getString("总学时") %></td>
					<td><%=rs2.getString("学时") %></td>
					<td><%=rs2.getString("任课教师编号")%></td>
					<td><%=rs2.getString("班级编号")%></td>
					<td><a href='docourse.jsp?experimentid=<%=rs2.getString("实验项目编号") %>&teacherid=<%=rs2.getString("任课教师编号")%>&experimentname=<%=rs2.getString("名称") %>&classid=<%=rs2.getString("班级编号")%>'>排 课</a></td>
					<td><a href='deletedocourse_?experimentid=<%=rs2.getString("实验项目编号") %>'>取消排课</a></td>
				</tr>	
<%		
	}
	rs1.close();
	rs2.close();
	st1.close();
	st2.close();
	con.close();
	
%>
			</tbody>
		</table>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>