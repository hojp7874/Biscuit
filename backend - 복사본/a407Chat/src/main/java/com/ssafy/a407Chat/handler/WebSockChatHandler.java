package com.ssafy.a407Chat.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.a407Chat.dao.ChatMessageDao;
import com.ssafy.a407Chat.dto.ChatMessageDto;
import com.ssafy.a407Chat.dto.ChatRoomDto;
import com.ssafy.a407Chat.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSockChatHandler extends TextWebSocketHandler{
	private final ObjectMapper objectMapper;
	private final ChatService chatService;
	
	@Autowired
	ChatMessageDao messageDao;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	{
		String payload = message.getPayload();
		log.info("payload {}", payload);
//		TextMessage textMessage = new TextMessage("hello");
//		session.sendMessage(textMessage);
		
		ChatMessageDto chatMessage = objectMapper.readValue(payload, ChatMessageDto.class);
		messageDao.insertMessage(chatMessage);
		ChatRoomDto room = chatService.findRoomById(chatMessage.getRoomId());
		room.handleActions(session, chatMessage, chatService);
	}
}
