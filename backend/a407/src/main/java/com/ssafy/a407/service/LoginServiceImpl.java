package com.ssafy.a407.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.a407.dao.LoginDao;
import com.ssafy.a407.dto.UserDto;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired //DAO 주입
	private LoginDao dao;
	
	@Override
	public UserDto login(Map<String, String> map) throws Exception {
		System.out.println("service : " + map);
		return dao.login(map);
	}

	@Override
	public int join(UserDto user) throws Exception {
		System.out.println("service : " + user);
		return dao.insertUser(user);
	}

	@Override
	public int remove(Map mem) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service : " + mem);
		return dao.removeUser(mem);
		
	}

	@Override
	public int update(Map mem) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service : " + mem);
		return dao.updateUser(mem);
	}

	@Override
	public UserDto profile(String email) throws Exception {
		// TODO Auto-generated method stub
		return dao.profileUser(email);
	}
}
