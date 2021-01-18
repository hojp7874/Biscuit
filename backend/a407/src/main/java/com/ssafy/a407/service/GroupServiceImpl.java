package com.ssafy.a407.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.a407.dao.GroupDao;
import com.ssafy.a407.dto.GroupDto;
import com.ssafy.a407.dto.MemberDto;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupDao dao;
	
	@Override
	public int createGroup(GroupDto group) throws Exception {
		return dao.insertGroup(group);
	}

	@Override
	public List<MemberDto> getMemberList(int gId) throws Exception {
		return dao.selectMemberList(gId);
	}

}
