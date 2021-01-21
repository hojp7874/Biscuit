package com.ssafy.a407.service;

import java.util.Map;

import com.ssafy.a407.dto.UserDto;

public interface LoginService {
	public UserDto login(Map<String, String> map) throws Exception;
	public int join(UserDto user) throws Exception;
	public int remove(Map mem) throws Exception;
	public int update(Map mem) throws Exception;
	public int pwupdate(Map mem) throws Exception;
	public UserDto profile(String email) throws Exception;
	public int updateAdmin(Map mem) throws Exception;
}
