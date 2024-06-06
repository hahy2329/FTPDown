package com.application.FTP.blackjack;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.application.FTP.HomeController;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String user_id = (String)authentication.getPrincipal();
		String user_pw = (String)authentication.getCredentials();
		
		logger.info("Welcome authenticate! {}" + user_id + "/" + user_pw);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
