package com.application.FTP.user.dao;

public interface UserDAO {
	
	public String checkDuplicated(String userId) throws Exception;
	public String checkDuplicatedEmail(String userEmail) throws Exception;
}
