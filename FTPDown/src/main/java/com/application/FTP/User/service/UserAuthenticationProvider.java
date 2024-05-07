package com.application.FTP.User.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.FTP.User.dto.UserDTO;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Component("userAuthenticationProvider")
@SuppressWarnings("unchecked")
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		
		if(username.equals("")) {
			return null;
		}
		
		logger.info("ID : " + username);
		logger.info("Password : " + password);
		
		
		UsernamePasswordAuthenticationToken result = null;
		UserDTO user1 = (UserDTO)customUserDetailsService.loadUserByUsername(username);
		
		
		try {
			if(user1 != null) {
				if(!customUserDetailsService.checkPassword(username, password)) {
					throw new BadCredentialsException(username);
				}
			}else {
				return null;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return new UsernamePasswordAuthenticationToken(username, password, user1.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
