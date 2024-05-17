package com.application.FTP.User.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


/*
 * 서버에 요청을 할 때 접근이 가능한지 권한을 체크 후 접근할 수 없는 요청을 했을 시 동작하기 위해
 * AccessDeniedHandler를 상속받는 핸들러를 구현한다.
 * 오류 페이지로 이동시키거나 에러코드를 반환하는 역할을 한다.
 * */
@Component
public class WebAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		//권한이 없는 경우 페이지 이동시 사용
		response.sendRedirect("/"); //오류페이지 URL 구현할 것
		
		//권한이 없는 경우 에러코드 반환 시 사용
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}

}
