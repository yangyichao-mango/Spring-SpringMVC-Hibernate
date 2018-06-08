package com.yyc.bo.impl;

import java.util.List;

import com.yyc.bo.*;
import com.yyc.dao.CourseInfoDao;
import com.yyc.entity.CourseInfo;

public class CourseInfoBoImpl implements CourseInfoBo{
	
	private CourseInfoDao courseInfoDao;
	
	public void setCourseInfoDao(CourseInfoDao courseInfoDao)
	{
		this.courseInfoDao = courseInfoDao;
	}

	public CourseInfoBoImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<CourseInfo> getCourseInfo(Integer courseId) {
		// TODO Auto-generated method stub
		return courseInfoDao.getCourseInfo(courseId);
	}

}
