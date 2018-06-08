<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			alert("确定退选当前课程？");
			var href = $(this).attr("href");
			$(".deleteForm").attr("action", href).submit();
			return false;
		});
	})
	
	$(function() {
		$(".post").click(function() {
			alert("确定选择当前课程？");
			var href = $(this).attr("href");
			
			$(".chooseForm").attr("action", href).submit();
			return false;
		});
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include   page="navigation.jsp" flush="true"/>
<body>
	<form class = "deleteForm" action="" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	
	<form class = "chooseForm" action="" method="POST">
		<input type="hidden" name="_method" value="POST">
	</form>
	<h5>已选课程</h5>
	<table border="1">

		<tbody>
			<tr>
				<th>课程名</th>
				<th>年级</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>操作</th>
				<th>详细信息</th>
			</tr>
			<c:if test="${!empty chooseCourse }">
				<c:forEach items="${chooseCourse }" var="course">
					<tr>
						<td>${course.courseName }</td>
						<td>${course.grade }</td>
						<td>${course.beginDate }</td>
						<td>${course.endDate }</td>

						<td><a class = "delete"
						href="${pageContext.servletContext.contextPath}/users/${user.userId}/courses/${course.courseId}">退选</a></td>
						<td><a
						href="${pageContext.servletContext.contextPath}/users/${user.userId}/courses/${course.courseId}">详细信息</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
		<h5>未选课程</h5>
	<table border="1">

		<tbody>
			<tr>
				<th>课程名</th>
				<th>年级</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>操作</th>
				<th>详细信息</th>
			</tr>
			<c:if test="${!empty otherCourse }">
				<c:forEach items="${otherCourse }" var="course">
					<tr>
						<td>${course.courseName }</td>
						<td>${course.grade }</td>
						<td>${course.beginDate }</td>
						<td>${course.endDate }</td>

						<td>
						<a class = "post"
						href="${pageContext.servletContext.contextPath}/users/${user.userId}/courses/${course.courseId}">选择</a>
						</td>
						<td>
						<a href="${pageContext.servletContext.contextPath}/users/${user.userId}/courses/${course.courseId}">详细信息</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

<h5>所有课程</h5>
	<table border="1">

		<tbody>
			<tr>
				<th>课程名</th>
				<th>年级</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>详细信息</th>
			</tr>
			<c:if test="${!empty allCourse }">
				<c:forEach items="${allCourse }" var="course">
					<tr>
						<td>${course.courseName }</td>
						<td>${course.grade }</td>
						<td>${course.beginDate }</td>
						<td>${course.endDate }</td>
						<td>
						<a href="${pageContext.servletContext.contextPath}/users/${user.userId}/courses/${course.courseId}">详细信息</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	

</body>
</html>