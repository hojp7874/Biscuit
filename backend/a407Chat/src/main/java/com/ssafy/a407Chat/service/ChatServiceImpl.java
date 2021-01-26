package com.ssafy.a407Chat.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.a407Chat.dao.ChatMessageDao;
import com.ssafy.a407Chat.dao.ChatRoomDao;
import com.ssafy.a407Chat.dto.ChatRoomDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService{

	private final ObjectMapper ObjectMapper;
	private Map<String, ChatRoomDto> chatRoomMap;
	
	@Autowired
	private ChatRoomDao roomDao;
	
	@Autowired
	private ChatMessageDao messageDao;
	
	@PostConstruct
	private void init() {
		chatRoomMap = new LinkedHashMap<>();
	}
	
	@Override
	public List<ChatRoomDto> findAllRoom() {
		List chatRooms = new ArrayList<>(chatRoomMap.values());
	    Collections.reverse(chatRooms);
		return chatRooms;
	}

	@Override
	public ChatRoomDto findRoomById(String roomId) {
		return chatRoomMap.get(roomId);
	}

	//랜덤 id로 방생성
	@Override
	public ChatRoomDto createRoom(ChatRoomDto dto) {
		String roomName = dto.getRoomName();
		int gId = dto.getGId();
		ChatRoomDto chatRoom = ChatRoomDto.create(roomName, gId);
		try {
			roomDao.insertRoom(chatRoom);
			chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
			return chatRoom;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		
	}

	@Override
	public <T> void sendMessage(WebSocketSession session, T message) {
		try {
			session.sendMessage(new TextMessage(ObjectMapper.writeValueAsString(message)));
		} catch (IOException e) {
			log.error(e.getMessage(), e);

		}
	}

}
