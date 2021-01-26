package com.ssafy.a407Chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

import com.ssafy.a407Chat.dto.ChatRoomDto;

public interface ChatService {
	public List<ChatRoomDto> findAllRoom();
	public ChatRoomDto findRoomById(String roomId);
	public ChatRoomDto createRoom(ChatRoomDto dto);
	public <T> void sendMessage(WebSocketSession session, T message);
}
