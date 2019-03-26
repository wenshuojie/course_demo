<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regist</title>
</head>
<body>
<html lang="en">
<head>
    <link href="bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>regist</title>
    <script type="text/javascript">
		function back(){
			window.location.href="login.jsp";
		}
		function check1(){
			var userid=document.getElementById("userid").value;
			if(userid.length!=12){
				document.getElementById("inf1").innerHTML="<font style='color: red;'>&nbsp;&nbsp;&nbsp;请输入十二位账号</font>";
			}
			else{
				document.getElementById("inf1").innerHTML="<font style='color: green;'>&nbsp;&nbsp;&nbsp;格式正确</font>";
			}
		}
		function check2(){
			var pwd = document.getElementById("password").value;
			var repwd = document.getElementById("repassword").value;
			if(pwd!=repwd){
				document.getElementById("inf2").innerHTML="<font style='color: red;'>密码不一致</font>";
			}
			else{
				document.getElementById("inf2").innerHTML="<font style='color: green;'>密码一致</font>";
			}
		}
	</script>
</head>
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
<body>
<div id="body"><img src="img/login.png"/></div>
<div class="line">&nbsp;</div>
<div id="foot">
    <form action="regist_" method="post">
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">教师号</span>
            <input type="text" class="form-control" id="teacherID" name="teacherID" placeholder="请输入教师号"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">姓名</span>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名"/>
        </div>
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">账号</span>
            <input type="text" class="form-control" id="userid" name="userid" placeholder="请输入账号" onkeyup="check1()"/><span id="inf1"></span>
        </div>					
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">密码</span>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>
        <br />
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">确认密码</span>
            <input type="password" class="form-control" id="repassword" name="repassword" placeholder="请输入密码" onkeyup="check2()"/><span id="inf2"></span>
        </div>					
        <br/>
        <div class="input-group input-group-lg" style="margin-left: 31%;">
            <span class="input-group-addon" style="width: 100px;!importent">教师类型</span>
            <select class="form-control" id="techertype" name="techertype" style="width:500px;"> 
            	<option value="管理员">管理员</option> 
            	<option value="普通教师">普通教师</option> 
            </select>       
        </div>
        <br />
        <input type="submit" class="btn btn-default" id="sub" value="注 册" style="margin-left: 34%;"/> <br />
    </form>
</div>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>
</body>
</html>