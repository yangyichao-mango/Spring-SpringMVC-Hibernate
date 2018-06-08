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
@Table(name = "courseInfo")
public class CourseInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseInfoId;
	
	@Column
	private Integer courseId;
	@Column
	private String courseInfo;
	@Column
	private String location;
	@Column
	@Past
	//��֤ע���Ԫ��ֵ���������ͣ��ȵ�ǰʱ����
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	
	public void setCourseInfoId(Integer courseInfoId)
	{
		this.courseInfoId = courseInfoId;
	}
	
	public Integer getCourseInfoId()
	{
		return courseInfoId;
	}
	
	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}
	
	public Integer getCourseId()
	{
		return courseId;
	}
	
	public void setCourseInfo(String courseInfo)
	{
		this.courseInfo = courseInfo;
	}
	
	public String getCourseInfo()
	{
		return courseInfo;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setTime(Date time)
	{
		this.time = time;
	}
	
	public Date getTime()
	{
		return time;
	}

	public CourseInfo() {
		// TODO Auto-generated constructor stub
	}

}
