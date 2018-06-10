package com.yyc.bo.impl;  
  
import java.util.List;

import com.yyc.bo.UserBo;
import com.yyc.dao.UserDao;
import com.yyc.entity.User;  
  
public class UserBoImpl implements UserBo {  
  
    private UserDao userDao;  
      
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
  
   
    public User findUser(String password,String username,Integer status) {  
        return userDao.findUser(password,username,status);  
    }  
  

  
  
    public void addUser(User user) {  
        userDao.addUser(user);  
    }  
  
  

  
    public boolean updateUser(User user) {  
        return userDao.updateUser(user);  
    }


	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}  
  
}  