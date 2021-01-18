package com.ssafy.a407.dto;

public class MemberDto {
	private int mId; //그룹 멤버 아이디
	private int gId; //그룹 아이디(번호)
	private String email; //멤버 아이디
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int gmid, int gid, String email) {
		super();
		this.mId = gmid;
		this.gId = gid;
		this.email = email;
	}

	public int getGmid() {
		return mId;
	}

	public void setGmid(int gmid) {
		this.mId = gmid;
	}

	public int getGid() {
		return gId;
	}

	public void setGid(int gid) {
		this.gId = gid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDto [mId=" + mId + ", gId=" + gId + ", email=" + email + "]";
	}
	
	
}
