package com.application.FTP.User.dao;

public interface UserDAO {

	public String checkDuplicatedId(String name) throws Exception;
	public String checkDuplicatedEmail(String email) throws Exception;
}
