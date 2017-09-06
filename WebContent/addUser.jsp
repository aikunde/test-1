<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<div align="center">
		<h1>
			<font face="华文彩云" color="skyblue" size="200px">添加联系人</font>
		</h1>
		<form name="addUser" action="handleAdd.jsp" method="post">
			<table border="0" align="center" cellspacing="20px">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="uname"
						placeholder="What is your name?" /></td>
				</tr>
				<tr>
					<td>工作：</td>
					<td><input type="text" name="ujob" value="null"
						onfocus="if(this.value=='null'){this.value=''}"
						onblur="if(value==''){value='null'}" /></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><input type="text" name="unick" value="null"
						onfocus="if(this.value=='null'){this.value=''}"
						onblur="if(value==''){value='null'}" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" name="uemail" value="null"
						onfocus="if(this.value=='null'){this.value=''}"
						onblur="if(value==''){value='null'}"></td>
				</tr>
				<tr>
					<td>日期：</td>
					<td><input type="text" name="udate" value="null"
						onfocus="if(this.value=='null'){this.value=''}"
						onblur="if(value==''){value='null'}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="添加" /> &nbsp;&nbsp;&nbsp;&nbsp; <input
						type="reset" name="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>