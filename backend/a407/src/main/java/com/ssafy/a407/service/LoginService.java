package com.ssafy.a407.service;

import java.util.Map;

import com.ssafy.a407.dto.UserDto;

public interface LoginService {
	public UserDto login(Map<String, String> map) throws Exception;
}
