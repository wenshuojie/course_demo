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
<title>classinfomation</title>
</head>
<body>
	<%
		String url = "jdbc:mysql://localhost/course_do_system";
		String sql = "select * from class order by 班级编号";
		
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 		
	%>
		<table class="table">
				<thead>
				      <tr>
				         <th>班级编号</th>
				         <th>专业</th>
				         <th>年级</th>
				         <th>人数</th>
				         <th>修改</th>
				         <th>删除信息</th>
				      </tr>
	   			</thead>
	   			<tbody>
	  <%
	  			while(rs.next()){
	  %>
	  				<tr>
					<td><%=rs.getString("班级编号") %></td>
					<td><%=rs.getString("专业") %></td>
					<td><%=rs.getString("年级") %></td>
					<td><%=rs.getString("人数") %></td>
					<td><a href='alterclass.jsp?classid=<%=rs.getString("班级编号") %>'>修改信息</a></td>
					<td><a href='deleteclass_?classid=<%=rs.getString("班级编号") %>'>删除</a></td>
					</tr>	  				
	  <%
	  			}
	  %>
	  				<tr>
	  					<td colspan="7">
	  						<a href='addclass.jsp'>添加班级信息</a>
	  					</td>
	  				</tr>
	  			</tbody>
	  		</table>
	  <%
	  %>
	  <button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>