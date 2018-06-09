package com.yyc.bo;

import java.util.List;

import com.yyc.entity.Course;

public interface CourseBo {
	
	public List<Course> getAllCourse();
	
	public List<Course> getUserCourse(Integer userId);
	
	public Integer createCourse(Course course);
	
	public Course getCourseByCourseId(Integer courseId);
	
	public List<Course> getOtherCourse(Integer userId);
	
}
