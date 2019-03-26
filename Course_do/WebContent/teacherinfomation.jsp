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
<title>teacherinfomation</title>
</head>
<body>
		<%
		String url = "jdbc:mysql://localhost/course_do_system";
		String sql = "select * from teacher order by 教师号";
		
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 		
	%>
		<table class="table">
				<thead>
				      <tr>
				         <th>工号</th>
				         <th>姓名</th>
				         <th>账号</th>
				         <th>密码</th>
				         <th>类型</th>
				         <th>删除信息</th>
				      </tr>
	   			</thead>
	   			<tbody>
	  <%
	  			while(rs.next()){
	  %>
	  				<tr>
					<td><%=rs.getString("教师号") %></td>
					<td><%=rs.getString("姓名") %></td>
					<td><%=rs.getString("账号") %></td>
					<td><%=rs.getString("密码") %></td>
					<td><%=rs.getString("类型") %></td>
					<td><a href='deleteteacher_?teacherid=<%=rs.getString("教师号") %>'>删除</a></td>
					</tr>	  				
	  <%
	  			}
	  %>
	  			</tbody>
	  		</table>
	  <%
	  %>
	  <button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>