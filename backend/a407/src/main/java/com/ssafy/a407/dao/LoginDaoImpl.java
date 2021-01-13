package com.ssafy.a407.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.a407.dto.UserDto;


@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired //sqlSession 주입
	SqlSession sqlSession;

	@Override
	public UserDto login(Map<String, String> map) throws Exception {
		
		return sqlSession.selectOne("",map);
	}
}
