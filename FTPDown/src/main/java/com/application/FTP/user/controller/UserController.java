package com.application.FTP.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.FTP.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/loginForm.do")
	public ModelAndView loginForm() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/user/loginForm");
		
		return mv;
		
	}
	
	@GetMapping("/checkDuplicated")
	public ResponseEntity<String> checkDuplicated(@RequestParam("userId") String userId) throws Exception{
		
		return new ResponseEntity<String>(userService.checkDuplicated(userId), HttpStatus.OK);
	}
	
	@GetMapping("/checkDuplicatedEmail")
	public ResponseEntity<String> checkDuplicatedEmail(@RequestParam("userEmail") String userEmail) throws Exception{
		
		return new ResponseEntity<String>(userService.checkDuplicatedEmail(userEmail), HttpStatus.OK);
		
	}
}
