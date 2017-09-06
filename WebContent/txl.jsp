<%@page import="org.lanqiao.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝桥通讯录</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript">

</script>
</head>
<body style="background: url(img/hengfu.jpg)">
	<%
		UserService us = new UserServiceImpl();
		List<User> list = us.list();
		int i=1;
	%>
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
					<li class="active"><a href="txl.jsp">联系人</a></li>
					<li><a href="addUser1.html">添加联系人</a></li>
					<li><a href="export.html">导出联系人</a></li>
					<li><a href="import.html">导入联系人</a></li>
				</ul>
			</div>
		</div>
	</div>

	<table class="table table-bordered table-hover" style="width: 70%"
		align="center">
		<caption>
			<a href="addUser1.html">添加用户</a> <font style="float: right" size="6">蓝桥通讯录</font>
		</caption>
		<tr>
			<th colspan="2">#</th>
			<th width="100px">姓名</th>
			<th>职业</th>
			<th>昵称</th>
			<th>邮箱</th>
			<th>日期</th>
			<th>操作</th>
		</tr>
		<% for(User u:list){ %>
		<tr>
			<td><a href="#" class="glyphicon glyphicon-plus"
				onclick="confirm('<%=u.getUmessage()%>')"></a></td>
			<td><%=i++%></td>
			<td><%=u.getUname() %></td>
			<td><%=u.getUjob() %></td>
			<td><%=u.getUnick() %></td>
			<td><%=u.getUemail() %></td>
			<td><%=u.getUdate() %></td>
			<td><a href="handleDel.jsp?id=<%=u.getUuid()%>"
				class="glyphicon glyphicon-remove"
				onclick="return confirm('是否确认删除')"></a> &nbsp;|&nbsp; <a
				href="updateUser.jsp?id=<%=u.getUuid()%>"
				class="glyphicon glyphicon-pencil"></a></td>
		</tr>
		<% } %>
	</table>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.1.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>