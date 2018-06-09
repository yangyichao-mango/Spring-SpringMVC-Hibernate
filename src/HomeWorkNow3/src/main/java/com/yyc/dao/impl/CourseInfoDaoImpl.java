package com.yyc.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

	public Boolean createCourseInfoList(Integer courseId,List<CourseInfo> courseInfoList) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CourseInfo courseInfo = null;
		Transaction tx = session.beginTransaction();
		for(int counter = 0;counter < courseInfoList.size();counter++)
		{
			courseInfo = courseInfoList.get(counter);
			courseInfo.setCourseId(courseId);
			
			if((Integer)session.save(courseInfo) == 0)
			{
				tx.rollback();
				return false;
			}
		}
		tx.commit();
		return true;
	}

}
