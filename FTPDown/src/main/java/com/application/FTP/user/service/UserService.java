package com.application.FTP.user.service;

public interface UserService {
	
	public String checkDuplicated(String userId) throws Exception;
	public String checkDuplicatedEmail(String userEmail) throws Exception;
}
