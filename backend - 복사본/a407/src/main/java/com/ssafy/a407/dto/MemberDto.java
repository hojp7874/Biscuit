package com.ssafy.a407.dto;

public class MemberDto {
	private int mId;
	private int gId;
	private String email;
	private int permission;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mId, int gId, String email, int permission) {
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

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "MemberDto [mId=" + mId + ", gId=" + gId + ", email=" + email + ", permission=" + permission + "]";
	}

	
	
}
