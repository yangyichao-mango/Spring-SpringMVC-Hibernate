package com.yyc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyc.bo.CourseBo;
import com.yyc.bo.CourseInfoBo;
import com.yyc.entity.Course;
import com.yyc.entity.CourseInfo;
import com.yyc.entity.CoursePackage;

@Controller
@RequestMapping(value = "courses")
public class CourseController {

	public CourseController() {
		// TODO Auto-generated constructor stub
	}
	
	@Resource
	private CourseBo courseBo;
	
	@Resource
	private CourseInfoBo courseInfoBo;
	
	
	@RequestMapping(method = RequestMethod.POST ,consumes = "application/json")
	public String createCourse(@RequestBody CoursePackage coursePackage,
			HttpServletRequest httpServletRequest)
	{
		Course course = coursePackage.getCourse();
		List<CourseInfo> courseInfoList = coursePackage.getCourseInfoList();
		Integer courseId = courseBo.createCourse(course);
		HttpSession session = httpServletRequest.getSession();
		if(courseId != 0)
		{
			if(courseInfoBo.createCourseInfoList(courseId, courseInfoList))
				session.setAttribute("info","创建课程成功");
			else
				session.setAttribute("info","创建课程失败");

		}
		else
		{
			session.setAttribute("info","创建课程失败");
		}
		
		return "redirect:/courses";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCreateCoursePage(HttpServletRequest httpServletRequest)
	{
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("info") != null)
		{
			httpServletRequest.setAttribute("info", session.getAttribute("info"));
			session.removeAttribute("info");
		}
		return "/createCourse";
	}

}
