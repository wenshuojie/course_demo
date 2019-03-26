<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		function back(){
			window.history.go(-1); 
		}
	</script>
	<title>look_1</title>
</head>
<body>
	<%
		String url = "jdbc:mysql://localhost/course_do_system";
		String userid = (String)session.getAttribute("userid");
		String sql1 = "select distinct 实验项目编号,名称, 班级编号 from course_do";
		//String sql2 = "select * from class where 任课教师编号 = (select 教师号 from teacher where 账号 = '"+userid+"')";
		
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement(); //执行课程表sql语句
		ResultSet rs = st.executeQuery(sql1); //课程表
		//ResultSet rs2 = st.executeQuery(sql2); //班级表
	%>
		<table class="table">
			<thead>
			      <tr>
			         <th>实验项目编号</th>
			         <th>实验名</th>
			         <th>班级编号</th>
			      </tr>
			      
			      
			      
   			</thead>
   			<tbody>
   	<%
   			while(rs.next()){
   	%>
   				 <tr>
			         <td><%=rs.getString("实验项目编号") %></td>
			         <td><%=rs.getString("名称") %></td>
			         <td><%=rs.getString("班级编号") %></td>  							         
			    </tr>
   	<%	
			         
   			}   
   			rs.close();
   			st.close();
   			con.close();
   	%>	
   			</tbody>
   		</table>
		<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>