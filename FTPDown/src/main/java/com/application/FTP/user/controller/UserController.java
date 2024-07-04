package com.application.FTP.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/loginForm.do")
	public ModelAndView loginForm() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/user/loginForm");
		
		return mv;
		
	}
}
