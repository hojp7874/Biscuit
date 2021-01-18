package com.ssafy.a407.service;

import java.util.List;

import com.ssafy.a407.dto.GroupDto;
import com.ssafy.a407.dto.MemberDto;

public interface GroupService {

	public int createGroup(GroupDto group) throws Exception;
	public List<MemberDto> getMemberList(int gId) throws Exception;
}
