package com.yyc.dao.impl;  
  
import java.util.List;  
  
import org.hibernate.Query;  
import org.hibernate.SessionFactory;

import com.yyc.dao.UserDao;
import com.yyc.entity.User;  
  
public class UserDaoImpl implements UserDao {  
  
    private SessionFactory sessionFactory;  
  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
      

    public User findUser(String password,String username) {  
        
        String hql = "from User u where u.username = ? AND u.password = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, username);  
        query.setString(1, password); 
          
        return (User)query.uniqueResult();  
    }  
  
  
    public void addUser(User user) {  
        sessionFactory.getCurrentSession().save(user);  
    }  


    public boolean updateUser(User user) {  
          
    	try{
    		sessionFactory.getCurrentSession().update(user);  
    	}catch(Exception e)
    	{
    		return false;
    	}
          
        return true;  
    }


	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		 String hql = "from User u where u.userId = ?";  
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        query.setInteger(0, userId);  
	          
	        return (User)query.uniqueResult();  
	}  
  
}  