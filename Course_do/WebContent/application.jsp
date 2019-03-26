<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>application教师申请排课</title>
	<link href="bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
     <script type="text/javascript">
		function back(){
			window.location.href="teacher.jsp";
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
				Class.forName("com.mysql.jdbc.Driver");// 加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st1 = con.createStatement(); //执行课程表sql语句
				Statement st2 = con.createStatement(); //执行课程表sql语句
				Statement st3 = con.createStatement(); //执行课程表sql语句
				ResultSet rs1 = st1.executeQuery("select 课程号 from course");
				ResultSet rs2 = st2.executeQuery("select 课程名 from course");
				ResultSet rs3 = st3.executeQuery("select * from class");
		%>
<div id="body"><img src="img/login.png"/></div>
<div class="line">&nbsp;</div>
<div id="foot">
	
    <form action="application_" method="post">
    <div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">课程</span>
	    <select class="form-control" id="courseid" name="courseid" style="width:500px;">
 			<%				
				while (rs1.next()) {
			%>
			<option value='<%=rs1.getString("课程号")%>'><%=rs1.getString("课程号")%></option>
			<%
				}
			%>
		</select>
	</div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
	    <span class="input-group-addon" style="width: 100px;!importent">课程</span>
	    <select class="form-control" id="coursename" name="coursename" style="width:500px;">
 			<%				
				while (rs2.next()) {
			%>
			<option value='<%=rs2.getString("课程名")%>'><%=rs2.getString("课程名")%>
			</option>
			<%
				}
			%>
		</select>
	</div>
	<br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">实验号</span>
            <input type="text" class="form-control" id="experimentid" name="experimentid" placeholder="请输入实验号"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">实验名</span>
            <input type="text" class="form-control" id="experimentname" name="experimentname" placeholder="请输入实验名"/>
        </div>
        <br />
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">总学时</span>
            <input type="text" class="form-control" id="totalhour" name="totalhour" placeholder="请输入总学时"/><span id="tishi_1"></span>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">实验学时</span>
            <input type="text" class="form-control" id="exhour" name="exhour" placeholder="请输入实验学时"/>          
        </div>
        <br />
        <div class="input-group input-group-lg" style="margin-left: 31%;">
       	 		<span class="input-group-addon" style="width: 100px;!importent">班级</span>
				 <select class="form-control" id="classid" name="classid" style="width:500px;"> 
			<%
				while (rs3.next()) {
			%>
			<option value='<%=rs3.getString("班级编号")%>'><%=rs3.getString("班级编号")%>&nbsp;
				<%=rs3.getString("专业")%>&nbsp;<%=rs3.getString("年级")%>级<%=rs3.getString("班级")%>班
			</option>
			<%
				}
			%>
		</select></div><br/>
        <input type="submit" class="btn btn-default" id="sub" value="申请" style="margin-left: 34%;"/> <br />
    </form>
</div>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>