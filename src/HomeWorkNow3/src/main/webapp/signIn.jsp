<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${info}</h5>
	<div>
	<form action="${pageContext.request.contextPath}/signIn" method = "post">
	<br>
		用户名: <input type="text" name="username" /> 
		<br>
		密码: <input type="password" name="password" /> 
		<br>
		状态: <input type="radio" name="status" value = "0">学生
		<input type="radio" name="status" value = "1">老师
		<br>
		
		<input type="submit" value="提交" />
	</form>
	</div>
	<div>
	<a href = "${pageContext.servletContext.contextPath }/signUp">注册</a>
	</div>
</body>
</html>