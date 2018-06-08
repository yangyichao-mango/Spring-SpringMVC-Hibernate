package com.yyc.entity;

import java.io.Serializable;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  
  
import org.hibernate.annotations.GenericGenerator;  

@Entity
@Table(name="choose")  

public class Choose implements Serializable{
	@Id
	@Column(length = 32)
	private Integer courseId;
	@Id
	@Column(length = 32)
	private Integer userId;
	
	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}
	
	public Integer getCourseId()
	{
		return courseId;
	}
	
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
	public Integer getUserId()
	{
		return userId;
	}

	public Choose() {
		// TODO Auto-generated constructor stub
	}

}
