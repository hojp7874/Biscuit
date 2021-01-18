package com.ssafy.a407.dto;

public class MemberDto {
	private int mId;
	private int gId;
	private String email;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mId, int gId, String email) {
		super();
		this.mId = mId;
		this.gId = gId;
		this.email = email;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
