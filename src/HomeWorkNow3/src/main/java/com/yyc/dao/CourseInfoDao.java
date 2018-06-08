package com.yyc.dao;

import java.util.List;

import com.yyc.entity.CourseInfo;

public interface CourseInfoDao {
	
	public List<CourseInfo> getCourseInfo(Integer courseId);

}
