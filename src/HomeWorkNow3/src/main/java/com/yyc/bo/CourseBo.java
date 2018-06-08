package com.yyc.bo;

import java.util.List;

import com.yyc.entity.Course;

public interface CourseBo {
	
	public List<Course> getAllCourse();
	
	public List<Course> getUserCourse(Integer userId);
	
	public List<Course> getOtherCourse(Integer userId);
	
}
