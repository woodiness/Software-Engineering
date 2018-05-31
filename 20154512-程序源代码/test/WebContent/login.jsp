<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>悦享生活</title>

<link href="css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.STYLE1 {
	font-family: "华文行楷";
	font-size: 36px;
}
.STYLE5 {font-size: 24px}
.STYLE6 {
	font-family: "楷体";
	font-size: 16px;
	color: #6699FF;
}
.STYLE7 {font-size: 16px}
-->
</style>
</head>
<body>
<%
	int flag_Login =1;
	try {
		flag_Login = (int)session.getAttribute("flag_Login");
	}catch (Exception e) {
		// TODO Auto-generated catch block
	}
%>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
			<h1 align="center" class="STYLE1 STYLE5">悦·享生活服务系统</h1>
			<h2 align="right" class="STYLE6">——让管理校园卡更简单</h2>
			<form action="CheckUser"method="post">
				<div class="name">
					<label>
					<div><span class="STYLE7">学    号</span></div>
					</label>
					
					<input type="text" class="text" id="value_1" placeholder="用户名" name="username" tabindex="1">
				</div>
				<div class="pwd">
					<label><span class="STYLE7">密　码</span></label>
					<input type="password" class="text" id="value_2" placeholder="密码" name="password" tabindex="2">
					<input type="submit" class="submit" tabindex="3" value="登录">
					<%if(flag_Login==0){ %>
						密码错误！<br>
					<%}else if(flag_Login==2){ %>
						用户名错误！
								<br>
					<%} %>
					<div class="check"></div>
				</div>
				</form>
				<br>
				<p><a href="http://118.89.248.160/phpmyadmin">
				管理员大大，这边有请~~</a></p>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script_login.js"></script>
</body>
</html>