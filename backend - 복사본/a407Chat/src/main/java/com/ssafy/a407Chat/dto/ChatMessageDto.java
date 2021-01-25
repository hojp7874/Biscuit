package com.ssafy.a407Chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {
	
	//메시지 타입 : 입장, 채팅
	public enum MessageType{
		ENTER, TALK
	}
	private int msgId;
	private MessageType type;
	private String roomId; // 방번호
	private String email; // 메시지 보낸 사람
	private String message;
}
