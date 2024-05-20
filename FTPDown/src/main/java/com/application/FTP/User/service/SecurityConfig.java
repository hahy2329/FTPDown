package com.application.FTP.User.service;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@EnableWebSecurity //SpringSecurityFilterChain 포함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Filter CustomAuthenticationProvider = null;

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
				
				//그 외 항목 전부 인증 적용
				.anyRequest()
				.authenticated()
				.and()
				
			
				.formLogin() // 로그인하는 경우에 대해 설정
					.loginPage("/user/login") // 로그인 페이지 URL을 설정
					.successForwardUrl("/") // 로그인 성공 후 이동할 URL 설정
					.failureForwardUrl("/user/login") // 로그인 실패 URL 설정
					.usernameParameter("username") // 로그인 시 ID 파라미터 값
					.passwordParameter("password") // 로그인 시 Password 파라미터 값
					.permitAll()
					.and()
				
				.logout() // 로그아웃 관련 URL 설정
					.logoutUrl("/user/logout") // 로그아웃 URL 설정
					.logoutSuccessUrl("/") // 로그아웃  성공 시 이동할 URL 설정
					.invalidateHttpSession(true) // 로그아웃 후 세션 초기화 설정
					.deleteCookies("JSESSIONID") // 로그아웃 후 쿠키 삭제 설정
					.and()
				
				//사용자 인증 필터 적용
				.addFilterBefore(CustomAuthenticationProvider, UsernamePasswordAuthenticationFilter.class);
					
				
				
	}
	
	
	/*
	 * customLoginSuccessHandler를 CustomAuthenticationFilter의 인증 성공 핸들러로 추가
	 * 로그인 성공 시 /user/login 로그인 url을 체크하고 인증 토큰 발급
	 * */
	
	@Bean
	public UsrCustomAuthenticationFilter usrCustomAuthenticationFilter() throws Exception{
		UsrCustomAuthenticationFilter customAuthenticationFilter = new UsrCustomAuthenticationFilter(authenticationManager());
		customAuthenticationFilter.setFilterProcessesUrl("/user/login");
		customAuthenticationFilter.setAuthenticationSuccessHandler(usrCustomLoginSuccessHandler());
		customAuthenticationFilter.setAuthenticationFailureHandler(usrCustomLoginFailHandler());
		customAuthenticationFilter.afterPropertiesSet();
		return customAuthenticationFilter;

		
	}
	
	
	// 로그인 성공 시 실행 될 handler bean 등록
	@Bean
	public UsrCustomLoginSuccessHandler usrCustomLoginSuccessHandler() {
		
		return new UsrCustomLoginSuccessHandler();
	}
	
	// 로그인 실패 시 실행 될 handler bean 등록
	@Bean
	public UserCustomLoginFailHandler usrCustomLoginFailHandler() {
		
		return new UserCustomLoginFailHandler();
	}
	
}
