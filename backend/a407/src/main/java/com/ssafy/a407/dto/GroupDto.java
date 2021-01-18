package com.ssafy.a407.dto;

public class GroupDto {
	private int gId; //그룹 아이디
	private String email; //그룹장 아이디
	private int max; //제한 인원
	private String sdate; //그룹 생성 날짜
	private String edate; //그룹 모집 완료 날짜
	private String groupname; //그룹명
	private String groupdesc; //그룹 설명
	private String category; // 분류
	private int onoff; // 온라인or 오프라인  : 0 - 온라인 , 1 - 오프라인 , 2 - 온라인+오프라인
	private String region; //지역 (시/도)
	private String img;  //그룹 이미지
	
	public GroupDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupDto(int gid, String email, int max, String sdate, String edate, String groupname, String groupdesc,
			String category, int onoff, String region, String img) {
		super();
		this.gId = gid;
		this.email = email;
		this.max = max;
		this.sdate = sdate;
		this.edate = edate;
		this.groupname = groupname;
		this.groupdesc = groupdesc;
		this.category = category;
		this.onoff = onoff;
		this.region = region;
		this.img = img;
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

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupdesc() {
		return groupdesc;
	}

	public void setGroupdesc(String groupdesc) {
		this.groupdesc = groupdesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getOnoff() {
		return onoff;
	}

	public void setOnoff(int onoff) {
		this.onoff = onoff;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "GroupDto [gId=" + gId + ", email=" + email + ", max=" + max + ", sdate=" + sdate + ", edate=" + edate
				+ ", groupname=" + groupname + ", groupdesc=" + groupdesc + ", category=" + category + ", onoff="
				+ onoff + ", region=" + region + ", img=" + img + "]";
	}
	
	

}
