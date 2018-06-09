package com.yyc.bo.impl;

import java.util.List;

import com.yyc.bo.CourseBo;
import com.yyc.dao.CourseDao;
import com.yyc.entity.Course;

public class CourseBoImpl implements CourseBo{
	
	private CourseDao courseDao;
	
	public void setCourseDao(CourseDao courseDao)
	{
		this.courseDao = courseDao;
	}

	public CourseBoImpl() {
		// TODO Auto-generated constructor stub
	}


	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse();
	}

	public List<Course> getUserCourse(Integer userId){
		// TODO Auto-generated method stub
		return courseDao.getUserCourse(userId);
	}


	public List<Course> getOtherCourse(Integer userId) {
		// TODO Auto-generated method stub
		return courseDao.getOtherCourse(userId);
	}

	public Integer createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.createCourse(course);
	}

	public Course getCourseByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return courseDao.getCourseByCourseId(courseId);
	}

}
