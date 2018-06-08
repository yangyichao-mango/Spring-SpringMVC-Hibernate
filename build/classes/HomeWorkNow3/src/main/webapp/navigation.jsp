<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>导航栏  用户名：${user.username }         年级：${user.grade }</h5>
<a href = "${pageContext.servletContext.contextPath}/users/${user.userId}" >编辑用户信息</a>
<a href = "${pageContext.servletContext.contextPath}/users/${user.userId}/courses" >我的课程</a>
<a href = "${pageContext.servletContext.contextPath}/signIn" >退出登录</a>
</body>
</html>