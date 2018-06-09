package com.yyc.dao;

import java.util.List;

import com.yyc.entity.Course;

public interface CourseDao {
	public List<Course> getAllCourse();
	
	public List<Course> getUserCourse(Integer userId);
	
	public Course getCourseByCourseId(Integer courseId);
	
	public List<Course> getOtherCourse(Integer userId);
	
	public Integer createCourse(Course course);
	
}
