package com.ssafy.a407Chat.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.a407Chat.dto.ChatMessageDto;

@Mapper
public interface ChatMessageDao {

	public int insertMessage(ChatMessageDto dto) throws Exception;
}
