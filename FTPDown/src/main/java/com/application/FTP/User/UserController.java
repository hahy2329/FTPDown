package com.application.FTP.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@GetMapping("/register") //유저 회원가입
	public ModelAndView register() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register");
		return mv;
	}
	
	@GetMapping("/login") // 유저 로그인
	public ModelAndView login() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}
	
}
