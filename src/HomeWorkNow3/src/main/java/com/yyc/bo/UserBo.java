package com.yyc.bo;  
  
import java.util.List;

import com.yyc.entity.User;  
  
public interface UserBo {  
  
    public User findUser(String password,String username);  
     
    public User findUserById(Integer userId); 
    
    public void addUser(User user);  
       
    public boolean updateUser(User user);

}  
