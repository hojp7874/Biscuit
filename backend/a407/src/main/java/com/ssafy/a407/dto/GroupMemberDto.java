package com.ssafy.a407.dto;

public class GroupMemberDto {
	private int mId;
	private int gId;
	private String email;
	private String groupName;
	private int permission;
	private String img;
	
	public GroupMemberDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupMemberDto(int mId, int gId, String email, String groupName, int permission, String img) {
		super();
		this.mId = mId;
		this.gId = gId;
		this.email = email;
		this.groupName = groupName;
		this.permission = permission;
		this.img = img;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
