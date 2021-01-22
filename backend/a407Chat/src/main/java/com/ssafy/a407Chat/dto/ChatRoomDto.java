package com.ssafy.a407Chat.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketSession;

import com.ssafy.a407Chat.dao.ChatMessageDao;
import com.ssafy.a407Chat.service.ChatService;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomDto {
	private String roomId;
	private String roomName;
	private int gId;
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	@Autowired
	ChatMessageDao messageDao;
	
	public ChatRoomDto() {
	}
	
	@Builder
	public ChatRoomDto(String roomId, String roomName,int gId) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.gId = gId;
	}
	
	public void handleActions(WebSocketSession session, ChatMessageDto chatMessage, ChatService chatService) {
		if(chatMessage.getType().equals(ChatMessageDto.MessageType.ENTER)) {
			sessions.add(session);
			chatMessage.setMessage(chatMessage.getEmail() + "님이  입장했습니다.");
		}
		
		sendMessage(chatMessage, chatService);
		
	}
	
	public <T> void sendMessage(T message, ChatService chatService) {
		
		sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
		
	}
}
	
	
