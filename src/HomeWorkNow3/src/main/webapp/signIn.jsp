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
		userName: <input type="text" name="username" /> 
		<br>
		password: <input type="password" name="password" /> 
		<br>
		<input type="submit" value="Submit" />
	</form>
	</div>
	<div>
	<a href = "${pageContext.servletContext.contextPath }/signUp">注册</a>
	</div>
</body>
</html>