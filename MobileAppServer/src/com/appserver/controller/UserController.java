package com.appserver.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.appserver.model.User;
import com.appserver.service.UserService;

@Controller
@RequestMapping("uc")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("lv")
	public String loginView() {
		return "loginView";
	}
	
	@RequestMapping(value="test", method=RequestMethod.POST)
	@ResponseBody
	public Object test(@ModelAttribute User user) {
		System.out.println(">>>>user>>>>"+user.getId()+" "+user.getUserName()+" "+user.getPassword());
		return user;
	}
	
	@RequestMapping(value="testpost", method=RequestMethod.POST)
	@ResponseBody
	public Object testPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("test", "hello "+request.getParameter("userName")+", 你好！");
		return map;
	}
	
	@RequestMapping("registerView")
	public String registerView() {
		return "registerView";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public ModelAndView login(User user) {
		ModelAndView mav = new ModelAndView();
		User u = userService.loginCheck(user);
		if (u == null) {
			mav.setViewName("login");
			mav.addObject("errorMsg", "用户名或密码有误！");
			return mav;
		} else {
			mav.setViewName("success");
			mav.addObject("user", u);
			return mav;
		}
	}
	
	@RequestMapping("register")
	@ResponseBody
	public ModelAndView register(User user) {
		ModelAndView mav = new ModelAndView();
		if (userService.register(user)) {
			mav.setViewName("login");
			return mav;
		} else {
			mav.setViewName("registerView");
			mav.addObject("errorMsg", "用户名已被占用，请更换！！");
			return mav;
		}
	}

}
