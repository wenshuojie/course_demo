<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员添加课程</title>
	<link href="bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
     <script type="text/javascript">
		function back(){
			window.location.href="courseinfomation.jsp";
		}
	</script>
    <style type="text/css">
    img{
        width: 200px;
        height: 200px;
        margin-top: 20px;
    }
    #body{
        width: 100%;
        height: 50%;
        text-align: center;
    }
    input{
        font-size: large;
        width: 500px!important;
    }
    #sub{
        width: 150px;
        margin-top: 10px;
    }
</style>
</head>
<body>
<%
		String url = "jdbc:mysql://localhost/course_do_system";
		String sql = "select * from teacher";
		
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 		
	%>
<div id="body"><img src="img/login.png"/></div>
<div class="line">&nbsp;</div>
<div id="foot">
    <form action="addcourse_" method="post">
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">课程号</span>
            <input type="text" class="form-control" id="courseid" name="courseid" placeholder="请输入课程号"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">课程名</span>
            <input type="text" class="form-control" id="coursename" name="coursename" placeholder="请输入课程名"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">总学时</span>
            <input type="text" class="form-control" id="time" name="time" placeholder="请输入总学时"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">教师编号</span>
            <select class="form-control" id="teacherid" name="teacherid" style="width:500px;">
 			<%				
				while (rs.next()) {
					if(rs.getString("类型").equals("管理员")){
			%>
				<option value='<%=rs.getString("教师号")%>' disabled="disabled"><%=rs.getString("教师号")%><%=rs.getString("姓名")%></option>
			<% 			
					}else{
			%>
			<option value='<%=rs.getString("教师号")%>'><%=rs.getString("教师号")%><%=rs.getString("姓名")%></option>
			<%
				}
				}
			%>
		</select>
        </div>
        <br />
        <input type="submit" class="btn btn-default" id="sub" value="添加" style="margin-left: 34%;"/> <br />
    </form>
</div>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>