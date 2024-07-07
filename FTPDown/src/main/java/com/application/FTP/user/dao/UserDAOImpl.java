package com.application.FTP.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String checkDuplicated(String userId) throws Exception {
		return sqlSession.selectOne("user.checkDuplicated", userId);
	}

}
