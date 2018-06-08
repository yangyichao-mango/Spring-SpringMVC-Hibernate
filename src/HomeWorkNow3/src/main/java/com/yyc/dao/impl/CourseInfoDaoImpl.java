package com.yyc.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yyc.dao.*;
import com.yyc.entity.CourseInfo;

public class CourseInfoDaoImpl implements CourseInfoDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 

	public CourseInfoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<CourseInfo> getCourseInfo(Integer courseId) {
		// TODO Auto-generated method stub
		String hql = "from CourseInfo where courseId = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setInteger(0, courseId);
		
		return query.list();
		
		
	}

}
