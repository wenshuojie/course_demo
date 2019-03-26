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
			window.history.go(-1); 
		}
	</script>
<title>Insert title here</title>
</head>
<body>
<%
	String url = "jdbc:mysql://localhost/course_do_system";
	String experimentid = request.getParameter("experimentid");
	String experimentname = request.getParameter("experimentname");
	String classid = request.getParameter("classid");
	String sql1 = "select * from course_do where 实验项目编号='"+experimentid+"'";
	String sql2 = "select * from class where 班级编号='"+classid+"'";
	
	Class.forName("com.mysql.jdbc.Driver");// 加载驱动
	Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
	Statement st1 = con.createStatement(); //执行课程表sql语句
	Statement st2 = con.createStatement(); 
	ResultSet rs1 = st1.executeQuery(sql1); //实验表
	ResultSet rs2 = st2.executeQuery(sql2);//班级表
	
	
%>
		<table class="table">
			<thead>
	<%
				while(rs2.next()){
	%>
				<tr style="background-color: #C4E3F3;">
			      	<td colspan="3"><span style="color: red;"><%=rs2.getString("专业") %>&nbsp;<%=rs2.getString("年级") %>级</span>实验</td>
			     </tr>
	<%			      
			    }
	%>
			      <tr>
			         <th>周次</th>
			         <th>星期数</th>
			         <th>节数</th>
			      </tr>
	
   			</thead>
   			<tbody>
   			
   			
<%		
			while(rs1.next()){
%>
			<tr>
			         <td><%=rs1.getString("周次") %></td>
			         <td><%=rs1.getString("星期数") %></td>
			         <td><%=rs1.getString("节数") %></td>			       			         
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