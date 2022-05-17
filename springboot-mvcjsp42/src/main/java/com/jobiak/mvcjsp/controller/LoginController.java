package com.jobiak.mvcjsp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobiak.mvcjsp.model.LoginBean;

public class LoginController {
	
	@RequestMapping(value="log",method=RequestMethod.POST)
	public String init(Model model) {
		model.addAttribute("msg","Please Enter Your Login Details");
		return "login";
	}
	
	@RequestMapping(value="log",method=RequestMethod.POST)
	public String submit(Model model,@ModelAttribute("loginBean")LoginBean loginBean) {
		if(loginBean!=null&&loginBean.getUserName()!=null&&loginBean.getPassword()!=null) {
			if(loginBean.getUserName().equals("Ninja")&&loginBean.getPassword().equals("passwword")) {
				model.addAttribute("msg",loginBean.getUserName());
				return "success";
			}else {
				model.addAttribute("error","Invalid Details");
				return "login";
			}
		}else {
			model.addAttribute("error","Please Enter Details");
			return "login";
		}
		
	}

}
