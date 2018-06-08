package com.yyc.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yyc.dao.ChooseDao;
import com.yyc.entity.Choose;

public class ChooseDaoImpl implements ChooseDao{
	
	private SessionFactory sessionFactory;  
	  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 

	public ChooseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public Integer deleteCourse(Choose choose) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(choose);
		}catch(Exception e)
		{
			return 0;
		}
        
        return 1;
    }

	public Integer chooseCourse(Choose choose) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(choose);
		}catch(Exception e)
		{
			return 0;
		}
        
        return 1;
	}

}
