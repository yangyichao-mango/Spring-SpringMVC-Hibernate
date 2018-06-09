package com.yyc.entity;

import java.util.List;

public class CoursePackage {

	public CoursePackage() {
		// TODO Auto-generated constructor stub
	}
	
	private Course course;
	
	private List<CourseInfo> courseInfoList;
	
	public void setCourse(Course course)
	{
		this.course = course;
	}
	
	public void setCourseInfoList(List<CourseInfo> courseInfoList)
	{
		this.courseInfoList = courseInfoList;
	}
	
	public Course getCourse()
	{
		return course;
	}
	
	public List<CourseInfo> getCourseInfoList()
	{
		return courseInfoList;
	}

}
