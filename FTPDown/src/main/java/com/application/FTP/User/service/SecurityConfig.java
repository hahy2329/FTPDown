package com.application.FTP.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //SpringSecurityFilterChain 포함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; // 비밀번호 암호화 로직
	
	@Autowired
	private WebAccessDeniedHandler webAccessDeniedHandler; // 권한이 없는 사용자 접근에 대한 handler
	
	@Autowired
	private WebAuthenticationEntryPoint webAuthenticationEntryPoint; // 인증되지 않은 사용자 접근에 대한 handler
	
	//실제 인증을 담당하는 provider
	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		
		return new CustomAuthenticationProvider(bCryptPasswordEncoder);
	}
	
	//스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
	}
	
}
