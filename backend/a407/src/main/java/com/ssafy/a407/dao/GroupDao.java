package com.ssafy.a407.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.a407.dto.GroupDto;
import com.ssafy.a407.dto.MemberDto;

@Mapper
public interface GroupDao {
	 public int insertGroup(GroupDto group) throws Exception;
	 public List<MemberDto> selectMemberList(int gId) throws Exception;
}
