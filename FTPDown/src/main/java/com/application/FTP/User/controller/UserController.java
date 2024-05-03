package com.application.FTP.User.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpHeaders;


import com.application.FTP.User.dto.UserDTO;
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
		logger.info("ID 중복확인 : " + name);
		
		return new ResponseEntity<String>(userService.checkDuplicatedId(name), HttpStatus.OK);
	}
	
	@GetMapping("/checkDuplicatedEmail") // 회원가입 EMAIL 중복체크
	public ResponseEntity<String> checkDuplicatedEmail(@RequestParam("email") String email) throws Exception{
		logger.info("email 중복확인 : " + email);
		
		return new ResponseEntity<String>(userService.checkDuplicatedEmail(email), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> insertRegister(UserDTO userDTO, HttpServletRequest request) throws Exception{
		logger.info("ID : ",userDTO.getName());
		logger.info("NickName : ",userDTO.getNickname());
		
		userService.insertRegister(userDTO);
		
		String message = "<script>";
		message +="alert('회원가입 완료!');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping("/loginSuccess")
	public ResponseEntity<Object> loginSuccess(HttpServletRequest request) throws Exception{
		String message = "";
		
		HttpSession httpSession = request.getSession();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		if(user == null) {
			message += "<script>";
			message += "alert('계정 인증 실패');";
			message += "history.go(-1)";
			message += "</script>";
			
			return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
			
		}else {
			
			httpSession.setAttribute("UserId", user.getUsername());
			httpSession.setMaxInactiveInterval(3600);
			
			message +="<script>";
			message +="alert('계정 인증 성공!');";
			message +="location.href='" + request.getContextPath() + "/';";
			message +="</script>";
			
			return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		}
		
	}
	
}
