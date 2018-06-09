package com.yyc.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yyc.dao.CourseDao;
import com.yyc.entity.Choose;
import com.yyc.entity.Course;

public class CourseDaoImpl implements CourseDao{
	
	private SessionFactory sessionFactory;  
	  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 

	public CourseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer createCourse(Course course)
	{
		Integer id = null;
		try{
			id = (Integer) sessionFactory.getCurrentSession().save(course);
		}catch(Exception e)
		{
			e.printStackTrace();
			return id;
		}
		return id;
	}


	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		String hql = "from Course ";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        
        return query.list();
	}


	public List<Course> getUserCourse(Integer userId) {
		// TODO Auto-generated method stub
        
		String hql = "select cu.courseId,cu.courseName, "
				+ "cu.beginDate,cu.endDate, "
				+ "cu.grade from Course cu , Choose co where cu.courseId = co.courseId "
				+ "and co.userId = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0,userId);
        List<Object[]> list = query.list();
        List<Course> res = new ArrayList<Course>();
        Course course = null;
        for(Object[] values : list)
        {
        	course = new Course();
        	course.setCourseId((Integer) values[0]);
        	course.setCourseName((String) values[1]);
        	course.setBeginDate((Date) values[2]);
        	course.setEndDate((Date) values[3]);
        	course.setGrade((String) values[4]);
        	res.add(course);
        }
        //System.out.println(((Course)(query.list().get(0))).getCourseName());
        return res;
        
		
	}

	public List<Course> getOtherCourse(Integer userId) {
		// TODO Auto-generated method stub
		String hql = "from Course cou where cou.courseId not in "
				+ "(select cu.courseId from Course cu ,Choose co "
				+ "where cu.courseId = co.courseId and co.userId = ?)";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, userId);
        return query.list();
	}

	public Course getCourseByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		String hql = "from Course where courseId = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, courseId);
        return (Course) query.uniqueResult();
	}

}
