package com.ssafy.a407Chat.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomDto {
	private String roomId;
	private String roomName;
	private int gId;

	public ChatRoomDto() {
		
	}
	
	public ChatRoomDto(String roomId, String roomName,int gId) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.gId = gId;
	}
	
	public static ChatRoomDto create(String roomName, int gId) {
		ChatRoomDto chatRoom = new ChatRoomDto();
		chatRoom.roomId = UUID.randomUUID().toString();
		chatRoom.roomName = roomName;
		chatRoom.gId = gId;
		return chatRoom;
		
	}
	
}
	
	
