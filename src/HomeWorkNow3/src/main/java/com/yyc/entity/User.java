package com.yyc.entity;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
  
import org.hibernate.annotations.GenericGenerator;  
  
@Entity  
@Table(name="user")  
public class User {  
  
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length=32)  
    private Integer userId;  
      
    @Column(length=32)  
    private String username;  
    
    @Column(length=32)  
    private String password;  
      
    @Column(length=32)  
    private Integer age;  
    
    @Column(length=32)  
    private String grade;  
    @Column(length = 32)
    private Integer status;
    
    public Integer getStatus()
    {
    	return status;
    }
    
    public void setStatus(Integer status)
    {
    	this.status = status;
    }
    
    public String getGrade() {  
        return grade;  
    }  
  
    public void setGrade(String grade) {  
        this.grade = grade;  
    }  
  
    public Integer getUserId() {  
        return userId;  
    }  
  
    public void setUserId(Integer userId) {  
        this.userId = userId;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
      
}  