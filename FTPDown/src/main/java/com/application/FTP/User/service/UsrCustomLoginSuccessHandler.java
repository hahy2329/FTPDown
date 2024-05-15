package com.application.FTP.User.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


/*
 * Form Login에서 로그인에 성공한 경우 동작하기 위해 SavedRequestAwareAuthenticationSuccessHandler를 상속받는 핸들러를 구성한다.
 * 로그인에 성공한 경우 인증 정보를 Spring Context Holder에 저장 후 지정된 페이지로 리다이렉트 하는 역할을 한다.
 * */

public class UsrCustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
		
		// Spring Context Holder에 인증 정보 저장
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
	}
	
}
