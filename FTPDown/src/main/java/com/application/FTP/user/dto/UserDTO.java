package com.application.FTP.user.dto;

import lombok.Data;

@Data
public class UserDTO {
	
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private int enabled;
}
