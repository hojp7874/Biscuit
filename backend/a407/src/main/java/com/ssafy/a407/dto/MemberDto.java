package com.ssafy.a407.dto;

public class MemberDto {
	private int mId;
	private int gId;
	private String email;
	private String permission;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mId, int gId, String email, String permission) {
		super();
		this.mId = mId;
		this.gId = gId;
		this.email = email;
		this.permission = permission;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	
	
}
