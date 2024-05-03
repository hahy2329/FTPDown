package com.application.FTP.User.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.application.FTP.User.dto.UserDTO;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		if(name.equals("")) {
			return null;
		}
		
		logger.info("ID : " + name);
		logger.info("Password : " + password);
		
		
		UsernamePasswordAuthenticationToken result = null;
		
		try {
			if(userService.loginCheckId(name) != null) {
				if(userService.checkPassword(name, password) == true) {
					UserDTO user = userService.loginCheckId(name);
					List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
					roles.add(new SimpleGrantedAuthority(user.getRole()));
					result = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), roles);
					result.setDetails(user);
				}else {
					return null;
					
				}
			}else {
				return null;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
