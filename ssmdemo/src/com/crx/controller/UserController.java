package com.crx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crx.pojo.User;
import com.crx.service.UserService;

@Controller
@RequestMapping("user")
@SessionAttributes("loginuser")
public class UserController {
    @Resource
	private UserService us;
    
    @RequestMapping("login")
    public String login(User user,Model model) {
    	User loginuser = us.login(user);
    	if(loginuser==null)
    		return "../login";
    	else {
    		model.addAttribute("loginuser", loginuser);
    		return "../main";
    	}
    }
}
