<%@page import="org.lanqiao.entity.User"%>
<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	UserService us = new UserServiceImpl();
	User u = us.search(request.getParameter("id"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑联系人</title>
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/modernizr.js"></script>
</head>
<body style="background: url(img/hengfu.jpg)">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">通讯录</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="index.html">首页</a></li>
					<li><a href="txl.jsp">联系人</a></li>
					<li><a href="addUser1.html">添加联系人</a></li>
					<li><a href="export.html">导出联系人</a></li>
					<li><a href="import.html">导入联系人</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div align="center">
		<div id="form">
			<form name="updateUserForm" action="handleUpdate.jsp" method="post"
				style="height: 685px; padding: 15px">
				<font>姓名：</font> <input type="text" name="uname"
					value="<%=u.getUname() %>" class="myInput inputText"
					onfocus="if(this.value=='<%=u.getUname() %>'){this.value=''}"
					onblur="if(value==''){value='<%=u.getUname() %>'}" /> <input
					type="hidden" name="uuid" value="<%=u.getUuid()%>" /> <font>工作：</font>
				<input type="text" name="ujob" value="<%=u.getUjob() %>"
					class="myInput inputText"
					onfocus="if(this.value=='<%=u.getUjob() %>'){this.value=''}"
					onblur="if(value==''){value='<%=u.getUjob() %>'}" /> <font>昵称：</font>
				<input type="text" name="unick" value="<%=u.getUnick() %>"
					class="myInput inputText"
					onfocus="if(this.value=='<%=u.getUnick() %>'){this.value=''}"
					onblur="if(value==''){value='<%=u.getUnick() %>'}" /> <font>邮箱：</font>
				<input type="text" name="uemail" value="<%=u.getUemail() %>"
					class="myInput inputText"
					onfocus="if(this.value=='<%=u.getUemail() %>'){this.value=''}"
					onblur="if(value==''){value='<%=u.getUemail() %>'}"> <font>日期：</font>
				<input type="text" name="udate" value="<%=u.getUdate()%>"
					class="myInput inputText"
					onfocus="if(this.value=='<%=u.getUdate()%>'){this.value=''}"
					onblur="if(value==''){value='<%=u.getUdate() %>'}">
				<textarea rows="4" cols="50" name="umessage" class="myTextarea"><%=u.getUmessage()%></textarea>
				<input type="submit" name="submit" class="myBtn" value="提交" /> <input
					type="reset" name="reset" class="myBtn" value="重置" />
			</form>
		</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.1.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>