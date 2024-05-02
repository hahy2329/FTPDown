package com.application.FTP.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.FTP.User.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
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

}
