package com.application.FTP.User.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.FTP.User.service.UserService;



@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
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
	
	@GetMapping("/checkDuplicatedId") //회원가입 ID 중복체크
	public ResponseEntity<String> checkDuplicatedId(@RequestParam("name") String name) throws Exception{
		logger.info(name);
		
		return new ResponseEntity<String>(userService.checkDuplicatedId(name), HttpStatus.OK);
	}
	
	@GetMapping("/checkDuplicatedEmail") // 회원가입 EMAIL 중복체크
	public ResponseEntity<String> checkDuplicatedEmail(@RequestParam("email") String email) throws Exception{
		logger.info(email);
		
		return new ResponseEntity<String>(userService.checkDuplicatedEmail(email), HttpStatus.OK);
		
	}
	
}
