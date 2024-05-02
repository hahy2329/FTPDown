package com.application.FTP.User.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.FTP.User.dao.UserDAO;
import com.application.FTP.User.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	private final UserDAO userDAO;
	
	@Override
	public String checkDuplicatedId(String name) throws Exception {
		
		if(userDAO.checkDuplicatedId(name) == null ) {
			return "notDuplicate";
		}else {
			return "Duplicate";
		}
		
	}

	@Override
	public String checkDuplicatedEmail(String email) throws Exception {
		if(userDAO.checkDuplicatedEmail(email) == null) {
			return "notDuplicate";
		}else {
			return "Duplicate";
		}
	}

	@Override
	public void insertRegister(UserDTO userDTO) throws Exception {
		userDTO.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));
		
		userDAO.insertRegister(userDTO);
	}

}
