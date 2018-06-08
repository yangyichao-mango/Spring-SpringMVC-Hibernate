package com.yyc.entity;

import java.util.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;  

@Entity
@Table(name="course")  
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=32)  
	private Integer courseId;
	
	@Column(length=32)  
	private String courseName;
	
	@Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(length=32)  
	private Date beginDate;
	
	@Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(length=32)  
	private Date endDate;
	
	@Column(length=32)  
	private String grade;
	
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	public String getGrade()
	{
		return grade;
	}

	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}
	
	public Date getBeginDate()
	{
		return beginDate;
	}
	
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}
	
	public Integer getCourseId()
	{
		return courseId;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

}
