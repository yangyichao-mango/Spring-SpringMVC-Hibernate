<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include   page="navigation.jsp" flush="true"/>
<h5>${info}</h5>
<h5>课程详情</h5>

<table border="1">

		<tbody>
			<tr>
				<th>课名</th>
				<th>上课时间</th>
				<th>上课教室</th>

			</tr>
			<c:if test="${!empty courseInfo }">
				<c:forEach items="${courseInfo }" var="course">
					<tr>
						<td>${course.courseInfo }</td>
						<td>${course.time }</td>
						<td>${course.location }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>
</html>