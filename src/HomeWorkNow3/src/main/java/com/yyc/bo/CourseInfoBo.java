package com.yyc.bo;

import java.util.List;

import com.yyc.entity.CourseInfo;

public interface CourseInfoBo {
	
	public List<CourseInfo> getCourseInfo(Integer courseId);

	public Boolean createCourseInfoList(Integer courseId,List<CourseInfo> courseInfoList);
}
