package com.yyc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyc.bo.ChooseBo;
import com.yyc.bo.CourseBo;
import com.yyc.bo.CourseInfoBo;
import com.yyc.bo.UserBo;
import com.yyc.entity.Choose;
import com.yyc.entity.Course;
import com.yyc.entity.CourseInfo;
import com.yyc.entity.User;

@Controller
@RequestMapping("/users")
public class UserController {

	@Resource(name = "userBoManager")
	private UserBo userBo;

	@Resource(name = "courseBoManager")
	private CourseBo courseBo;

	@Resource(name = "chooseBoManager")
	private ChooseBo chooseBo;
	
	@Resource(name = "courseInfoBoManager")
	private CourseInfoBo courseInfoBo;

	/*
	 * @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	 * public String delete(@PathVariable("id") Integer id) {
	 * System.out.println("delete"); employeeDao.delete(id); return
	 * "redirect:/emps"; }
	 *
	 */
	//显示当前用户界面
	@RequestMapping(value = "/{userId}/courses", method = RequestMethod.GET)
	public String index(Model model,HttpServletRequest httpServletRequest) {
		System.out.println("userPage");
		User res = (User) httpServletRequest.getSession().getAttribute("user");
		
		List<Course> chooseCourse = courseBo.getUserCourse(res.getUserId());
		model.addAttribute("chooseCourse", chooseCourse);

		List<Course> allCourse = courseBo.getAllCourse();
		model.addAttribute("allCourse", allCourse);

		List<Course> otherCourse = courseBo.getOtherCourse(res.getUserId());
		model.addAttribute("otherCourse", otherCourse);
		return "/index";
	}
	
	//用户查看课程详细信息
	@RequestMapping(value ="/{userId}/courses/{courseId}",method = RequestMethod.GET)
	public String getCourseInfo(Model model,@PathVariable("userId") Integer userId, @PathVariable("courseId") Integer courseId){
		List<CourseInfo> courseInfo = courseInfoBo.getCourseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo);
		return "/courseInfo";
	}
	//用户退选课程
	@RequestMapping(value = "/{userId}/courses/{courseId}", method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable("userId") Integer userId, @PathVariable("courseId") Integer courseId) {
		Choose choose = new Choose();
		choose.setUserId(userId);
		choose.setCourseId(courseId);
		chooseBo.deleteCourse(choose);
		return "redirect:/users/" + userId +"/courses";
	}
	//用户选择课程
	@RequestMapping(value = "/{userId}/courses/{courseId}", method = RequestMethod.POST)
	public String chooseCourse(@PathVariable("userId") Integer userId, @PathVariable("courseId") Integer courseId) {
		Choose choose = new Choose();
		choose.setUserId(userId);
		choose.setCourseId(courseId);
		chooseBo.chooseCourse(choose);
		return "redirect:/users/" + userId +"/courses";
	}
	
	//更新用户信息
	@RequestMapping(method = RequestMethod.PUT)
	public String editUser(User user) throws UnsupportedEncodingException {
		String grade = new String(user.getGrade().getBytes("ISO-8859-1"),"UTF-8");      
		user.setGrade(grade);
		userBo.updateUser(user);

		return "redirect:/users/"+user.getUserId();

	}
	//获取用户信息
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public String getUserInfo(User user,Model model)
	{
		User res = userBo.findUserById(user.getUserId());
		model.addAttribute("user",res);
		
		return "/editUser";
	}
}