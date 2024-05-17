package com.application.FTP.User.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class WebAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		//인증되지 않은 경우 페이지 이동 시 사용
		response.sendRedirect("/"); //에러페이지 구현할 것
		
		//인증되지 않은 경우 에러코드 반환 시 사용
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}

}
