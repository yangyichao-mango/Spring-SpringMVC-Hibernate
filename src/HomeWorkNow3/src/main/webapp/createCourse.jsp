<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page = "navigation.jsp"  flush = "true"/>
<body>
	<form action="${pageContext.request.contextPath}/courses" method = "post">
	<br>
		课程名: <input type="text" name="courseName" /> 
		<br>
		开始日期: <input type="date" name="beginDate" /> 
		<br>
		结束日期: <input type="date" name="endDate" /> 
		<br>
		年级: <input type="text" name="grade" /> 
		<br>
		
		<input type="submit" value="添加" />
	</form>
</body>
</html>