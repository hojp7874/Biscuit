package com.ssafy.a407Chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.ssafy.a407Chat.dto.ChatMessageDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {
	private final SimpMessageSendingOperations messagingTemplate;
	
	@MessageMapping("/chat/message")
	public void message(ChatMessageDto message) {
		if(ChatMessageDto.MessageType.ENTER.equals(message.getType())) {
			message.setMessage(message.getEmail() + "님이 입장하였습니다.");
		}
		messagingTemplate.convertAndSend("/sub/chat/romm/" + message.getRoomId(), message);
	}
}
