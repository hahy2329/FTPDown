package com.application.FTP.User.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.FTP.User.dao.UserDAO;
import com.application.FTP.User.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO user = null;
		
		try {
			user = userDAO.loginCheckId(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public boolean checkPassword(String name, String password) throws Exception{
		boolean check = false;
		UserDTO user = userDAO.loginCheckId(name);
		
		if(bcryptPasswordEncoder.matches(password, user.getPassword())) {
			check = true;
			
			return check;
			
		}else {
			
			return check;
		}
		
	}

}
