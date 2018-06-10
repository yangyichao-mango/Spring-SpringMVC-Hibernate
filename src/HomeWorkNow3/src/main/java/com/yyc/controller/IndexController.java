package com.yyc.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyc.bo.CourseBo;
import com.yyc.bo.UserBo;
import com.yyc.entity.User;

@Controller
public class IndexController {

	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	@Resource
	private UserBo userBo;
	
		//登录用于查找用户
	
		public User findUser(User user)
		{
			User res = userBo.findUser(user.getPassword(), user.getUsername(),user.getStatus());
			return res;
		}
		
		//用户登录界面
		@RequestMapping(value = "/signIn", method = RequestMethod.GET)
		public String signInPage(HttpServletRequest httpServletRequest) {
			HttpSession session = httpServletRequest.getSession();
			if(session.getAttribute("user") != null)
				session.removeAttribute("user");
				
			return "/signIn";
		}
		
		@RequestMapping(value = "/signUp", method = RequestMethod.POST)
		public String signUp(Model model,User user, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
			System.out.println("signIn");
			User res = findUser(user);
			if (res == null) {
				String grade = new String(user.getGrade().getBytes("ISO-8859-1"),"UTF-8"); 
				user.setGrade(grade);
				userBo.addUser(user);
				User now = findUser(user);
				HttpSession session = httpServletRequest.getSession();
				session.setAttribute("user", now);
				return "redirect:/users/" + now.getUserId() +"/courses";
			} else {
				model.addAttribute("info","注册失败");
				return "/signUp";
			}
		}
		
		@RequestMapping(value = "/signUp", method = RequestMethod.GET)
		public String signUpPage(User user, Model model) {
			
				return "/signUp";
		}
		
		//登录
		@RequestMapping(value = "/signIn", method = RequestMethod.POST)
		public String signIn(Model model,User user, HttpServletRequest httpServletRequest) {
			System.out.println("signIn");
			System.out.println("用户状态："+user.getStatus());
			User res = findUser(user);
			
			if (res != null) {
				HttpSession session = httpServletRequest.getSession();
				session.setAttribute("user", res);
				return "redirect:/users/" + res.getUserId() +"/courses";
			} else {
				model.addAttribute("info","用户名或者密码错误");
				return "/signIn";
			}
		}

}
