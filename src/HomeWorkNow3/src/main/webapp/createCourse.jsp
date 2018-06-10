<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.9.1.min.js"></script>

<style>
td {
	text-align: center; /*设置单元格样式*/
	width: 100px;
	height: 30px;
}

.tth {
	width: 80px; /*设置表格的意第一行的输入框样式*/
	height: 26px;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
}
</style>
<script>
	function create(row, d1) {//传递行输入框列输入框和区域
		//alert("123");
		var rows = row.value;//获取行数值
		var cols = 3;//获取列数值
		var text1 = "";
		var text2 = "";
		var nowForm = document.getElementById("courseInfoList");

		var newtable = document.createElement("TABLE");//创建一个table元素
		newtable.setAttribute("frame", "border");//设置表格外边框全部显示
		newtable.setAttribute("rules", "all");//设置表格内边框全部显示

		text1 = text1
				+ "<table><tr><td><input type=\"text\" class=\"tth\" name = \"courseInfo\"></td>"
				+ "<td><input type=\"date\" class=\"tth\" name = \"time\"></td>"
				+ "<td><input type=\"text\" class=\"tth\" name = \"location\"></td></tr></table>";

		text2 = text2
				+ "<table><tr><th>课程内容</th><th>上课时间</th><th>上课地点</th></tr></table>";

		for (var i = 0; i <= rows; i++) {//根据行数循环创建表格
			var c = newtable.insertRow(newtable.rows.length);
			if (i == 0) {
				c.innerHTML = text2;//创建第一行
			} else {
				c.innerHTML = text1;//创建普通行
			}
		}
		var sor = document.createElement("P");//创建一个P元素在其中放上保存表格按钮和编辑表格按钮
		sor.innerHTML = "<input type=\"button\" onclick=\"save()\" value=\"保存表格\">&nbsp&nbsp"+
		"<input type=\"button\" onclick=\"blank()\" value=\"编辑表格\">&nbsp&nbsp"+
		"<input type=\"button\" onclick=\"sub()\" value=\"提交表格\">";
		var fil = document.createElement("FIELDSET");//创建一个fieldset元素，将表格和按钮框起来
		var wi = cols * 100 + 20;//根据单元格的设置动态改变外框的大小
		fil.style.width = wi + "px";
		fil.appendChild(newtable);//将表格插入外框中
		fil.appendChild(sor);//将按键插入外框中
		nowForm.appendChild(fil);
		var inp = document.getElementsByTagName("input");//获取input元素集合
		inp[5].disabled = true;//将创建表格按钮失能
		return false;
	}
	function save() {//保存表格
		alert("确认提交？");
		var inp = document.getElementsByTagName("input");//获取input元素集合
		for (var i = 6; i < inp.length - 3; i++) {//将表格的所有input元素只读，同时使外框消失
			inp[i].readOnly = true;
			inp[i].style.borderStyle = "none";
		}
	}
	function blank() {//编辑表格
		alert("确认提交？");
		var inp = document.getElementsByTagName("input");//获取input元素集合
		for (var i = 6; i < inp.length - 3; i++) {//使表格的input元素恢复可编辑，并显示输入边框
			inp[i].readOnly = false;
			inp[i].style.borderStyle = "solid";
			inp[i].style.borderWidth = "0.1px";
		}
	}

	function sub() {//编辑表格
		
		//document.getElementById("courseInfoList").submit();
		var course = {};
		
		
		var courseInfoList = new Array();  
		var inp = document.getElementsByTagName("input");//获取input元素集合
		for (var i = 6; i < inp.length - 3; i+=3) {//使表格的input元素恢复可编辑，并显示输入边框
			var courseInfo = inp[i].value;
			var time = inp[i + 1].value;
			var location = inp[i + 2].value;
			
			courseInfoList.push({courseInfo:courseInfo,time:time,location:location}); 
		}
		course.courseName = inp[0].value;
		course.beginDate = inp[1].value;
		course.endDate = inp[2].value;
		course.grade = inp[3].value;
		alert("确认提交？" + course);
		$.ajax({  
		    type: "POST",  
		    url: "${pageContext.request.contextPath}/courses",  
		    data: JSON.stringify({
		    	course:course,
		    	courseInfoList:courseInfoList
		    	}),//将对象序列化成JSON字符串  
		    
		    dataType:"json",  
		    contentType : 'application/json;charset=utf-8', //设置请求头信息  
		    success: function(data){  
		    	document.location.reload();
		    },  
		    error: function(res){  
		    	document.location.reload();
		    }  
		}); 
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<%@ include file="navigation.jsp"%>
<body>
	<h5>${info}</h5>

	<div id="d1">
		<form id="courseInfoList"
			action="${pageContext.request.contextPath}/courses" method="post">
			课程名: <input type="text" name="courseName" /> <br> 开始日期: <input
				type="date" name="beginDate" /> <br> 结束日期: <input type="date"
				name="endDate" /> <br> 年级: <input type="text" name="grade" />
			<br> 请输入课程节数：<input type="number" id="row" max="20" min="1"
				required="required" title="列数范围1-20"> <input type="submit"
				value="创建该课程信息表格" onclick="return create(row,d1);"> <br>
		</form>
	</div>

</body>
</html>