package com.application.FTP.User.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String checkDuplicatedId(String name) throws Exception {
		return sqlSession.selectOne("user.checkDuplicatedId", name);
	}
	
	
}
