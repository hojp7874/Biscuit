package com.ssafy.a407.dto;

public class GroupDto {
	private int gid;
	private String email;
	private int max;
	private String sdate;
	private String edate;
	private String groupname;
	private String groupdesc;
	private String category;
	private int onoff;
	private String region;
	private String img;
	
	public GroupDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupDto(int gid, String email, int max, String sdate, String edate, String groupname, String groupdesc,
			String category, int onoff, String region, String img) {
		super();
		this.gid = gid;
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
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
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
		return "GroupDto [gid=" + gid + ", email=" + email + ", max=" + max + ", sdate=" + sdate + ", edate=" + edate
				+ ", groupname=" + groupname + ", groupdesc=" + groupdesc + ", category=" + category + ", onoff="
				+ onoff + ", region=" + region + ", img=" + img + "]";
	}
	
	

}
