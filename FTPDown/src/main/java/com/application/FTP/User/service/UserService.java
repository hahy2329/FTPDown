package com.application.FTP.User.service;

import com.application.FTP.User.dto.UserDTO;

public interface UserService {

	public String checkDuplicatedId(String name) throws Exception;
	public String checkDuplicatedEmail(String email) throws Exception;
	public void insertRegister(UserDTO userDTO) throws Exception;
}
