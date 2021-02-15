package com.ssafy.a407Chat.dto;

public class ChatRoomMemberDto {
	private int crmId;
	private String roomId;
	private String email;
	private String nickname;
	
	public ChatRoomMemberDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatRoomMemberDto(int crmId, String roomId, String email, String nickname) {
		super();
		this.crmId = crmId;
		this.roomId = roomId;
		this.email = email;
		this.nickname = nickname;
	}

	public int getCrmId() {
		return crmId;
	}

	public void setCrmId(int crmId) {
		this.crmId = crmId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
