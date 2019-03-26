<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员添加班级</title>
	<link href="bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
     <script type="text/javascript">
		function back(){
			window.location.href="classinfomation.jsp";
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
<div id="body"><img src="img/login.png"/></div>
<div class="line">&nbsp;</div>
<div id="foot">
    <form action="addclass_" method="post">
        <div class="input-group input-group-lg" style="margin-left: 31%;">
	            <span class="input-group-addon" style="width: 100px;!importent">班级编号</span>
	            <input type="text" class="form-control" id="classid" name="classid" placeholder="请输入班级编号"/>
	        </div>
	        <br/>
	        <div class="input-group input-group-lg" style="margin-left: 31%;">
	            <span class="input-group-addon" style="width: 100px;!importent">专业</span>
	            <input type="text" class="form-control" id="major" name="major" placeholder="请输入专业"/>
	        </div>
	        <br/>
	        <div class="input-group input-group-lg" style="margin-left: 31%;">
	            <span class="input-group-addon" style="width: 100px;!importent">年级</span>
	            <input type="text" class="form-control" id="grade" name="grade" placeholder="请输入年级"/>
	        </div>
	        <br/>
	         <div class="input-group input-group-lg" style="margin-left: 31%;">
	            <span class="input-group-addon" style="width: 100px;!importent">班级</span>
	            <input type="text" class="form-control" id="banji" name="banji" placeholder="请输入班级"/>
	        </div>
	        <br/>
	        <div class="input-group input-group-lg" style="margin-left: 31%;">
	            <span class="input-group-addon" style="width: 100px;!importent">人数</span>
	            <input type="text" class="form-control" id="p_num" name="p_num" placeholder="请输入人数"/>
	        </div>
	        <br />
	        <input type="submit" class="btn btn-default" id="sub" value="添加" style="margin-left: 34%;"/> <br />
    </form>
</div>
	<button onclick="back()" class="btn btn-default" style="margin-left:46%;margin-top:10px;width:130px">返 回</button>
</body>
</html>