package com.application.FTP.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
	
	/*
	 * 스프링 시큐리티 룰을 무시할 URL 규칙 설정
	 * 정적 자원에 대해서는 security 설정을 적용하지 않음
	 * */
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		web.ignoring()
			.antMatchers("/resources/**")
			.antMatchers("/css/**")
			.antMatchers("/vendor/**")
			.antMatchers("/jquery-3.4.1.min.js")
			.antMatchers("/favicon/**")
			.antMatchers("/img/**");
	}
	
	// 스프링 시큐리티 규칙
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable() //csrf 보안 설정 비활성화
				.antMatcher("/**").authorizeRequests() // 보호된 리소스 URI에 접근할 수 있는 권한 설정
				
				
				.antMatchers("/").permitAll() // 전체 접근 허용
				.antMatchers("/login").anonymous() // 인증되지 않은 사용자만 접근 허용
				.antMatchers("/register").anonymous() // 인증되지 않은 사용자만 접근 허용
				.
	}
	
}
