<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<jsp:include   page="navigation.jsp" flush="true"/>
<body>  
    <h1>编辑用户</h1> 
    <form action="${pageContext.servletContext.contextPath}/users" name="userForm" method="post">  
        <input type="hidden" name="userId" value="${user.userId }">  
        <input type="hidden" name="_method" value="PUT" />
        姓名：<input type="text" name="username" value="${user.username }">  
        年龄：<input type="text" name="age" value="${user.age }">  
        年级：<input type="text" name="grade" value="${user.grade }">  
        密码：<input type="password" name="password" value="">  
        <input type="submit" value="提交">  
    </form>  
</body>  
</html>  
