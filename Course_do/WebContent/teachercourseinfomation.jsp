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
			window.location.href="teacher.jsp";
		}
	</script>
<title>courseinfomation</title>
</head>
<body>
	<%
		String url = "jdbc:mysql://localhost/course_do_system";
		String sql = "select * from course order by 课程号";
		
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 		
	%>
		<table class="table">
				<thead>
				      <tr>
				         <th>课程号</th>
				         <th>课程名</th>
				         <th>总学时</th>
				         <th>任课教师编号</th>				    
				      </tr>
	   			</thead>
	   			<tbody>
	  <%
	  			while(rs.next()){
	  %>
	  				<tr>
					<td><%=rs.getString("课程号") %></td>
					<td><%=rs.getString("课程名") %></td>
					<td><%=rs.getString("总学时") %></td>
					<td><%=rs.getString("任课教师编号") %></td>					
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