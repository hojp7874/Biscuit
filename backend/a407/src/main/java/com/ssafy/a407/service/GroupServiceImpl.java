package com.ssafy.a407.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.a407.dao.GroupDao;
import com.ssafy.a407.dto.GroupDto;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupDao dao;
	
	@Override
	public int remove(int gId) throws Exception {
		// TODO Auto-generated method stub
		return dao.removeGroup(gId);
	}

	@Override
	public int update(Map mem) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateGroup(mem);
	}

}
