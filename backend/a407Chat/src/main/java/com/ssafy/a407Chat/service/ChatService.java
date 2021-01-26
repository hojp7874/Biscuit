package com.ssafy.a407Chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

import com.ssafy.a407Chat.dto.ChatRoomDto;

public interface ChatService {
	public List<ChatRoomDto> findAllRoom() throws Exception;
	public ChatRoomDto findRoomById(String roomId) throws Exception;
	public ChatRoomDto createRoom(ChatRoomDto dto) throws Exception;
	public <T> void sendMessage(WebSocketSession session, T message) throws Exception;
}
