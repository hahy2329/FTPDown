package com.application.FTP.User.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.FTP.User.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String checkDuplicatedId(String name) throws Exception {
		return sqlSession.selectOne("user.checkDuplicatedId", name);
	}

	@Override
	public String checkDuplicatedEmail(String email) throws Exception {
		return sqlSession.selectOne("user.checkDuplicatedEmail", email);
	}

	@Override
	public void insertRegister(UserDTO userDTO) throws Exception {
		sqlSession.insert("user.insertRegister", userDTO);
		
	}

	@Override
	public UserDTO loginCheckId(String name) throws Exception {
		return sqlSession.selectOne("user.loginCheckId", name);
	}
	
	
}
