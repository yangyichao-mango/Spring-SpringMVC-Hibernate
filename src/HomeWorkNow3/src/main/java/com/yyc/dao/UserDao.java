package com.yyc.dao;  
  
import java.util.List;

import com.yyc.entity.User;  
  
public interface UserDao {  
  
    public User findUser(String password,String username, Integer status);  
    
    public User findUserById(Integer userId); 

    public void addUser(User user);  
      
    public boolean updateUser(User user);  
}  
