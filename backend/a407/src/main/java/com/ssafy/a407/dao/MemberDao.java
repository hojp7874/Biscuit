package com.ssafy.a407.dao;

import java.util.Map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.a407.dto.GroupDto;
import com.ssafy.a407.dto.GroupMemberDto;
import com.ssafy.a407.dto.MemberDto;
import com.ssafy.a407.dto.UserMemberDto;

@Mapper
public interface MemberDao {


	 public List<UserMemberDto> selectMemberList(int gId) throws Exception;
	 public List<UserMemberDto> selectApplyList(int gId) throws Exception;
	 public List<GroupMemberDto> selectGroupList(String email) throws Exception;
	 
	 
	 public int insertMember(MemberDto member) throws Exception;
	 
	 public int updateMemberPermission(Map input) throws Exception;

	 public int deleteMemberApply(int mId) throws Exception;
}
