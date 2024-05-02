package com.application.FTP.User.service;

public interface UserService {

	public String checkDuplicatedId(String name) throws Exception;
	public String checkDuplicatedEmail(String email) throws Exception;
}
