package com.ssafy.a407.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.a407.dto.UserDto;


@Mapper
public interface LoginDao {
	public UserDto login(Map<String, String> map) throws Exception;
	public void insertUser(UserDto user) throws Exception;
	public void removeUser(String email) throws Exception;
	
}
