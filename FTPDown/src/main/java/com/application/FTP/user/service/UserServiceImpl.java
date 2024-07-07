package com.application.FTP.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.FTP.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public String checkDuplicated(String userId) throws Exception {
		if(userDAO.checkDuplicated(userId) == null) {
			return "NotDuplicate";
		}else {
			return "Duplicate";
		}
	}

}
