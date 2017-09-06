package org.lanqiao.entity;

import java.sql.Date;

public class User {
	private String uuid;
	private String uname;
	private String ujob;
	private String unick;
	private String uemail;
	private java.sql.Date udate;
	private String umessage;
	public User() {}
	public User(String uuid, String uname, String ujob, String unick, String uemail, Date udate, String umessage) {
		super();
		this.uuid = uuid;
		this.uname = uname;
		this.ujob = ujob;
		this.unick = unick;
		this.uemail = uemail;
		this.udate = udate;
		this.umessage = umessage;
	}
	public String getUmessage() {
		return umessage;
	}
	public void setUmessage(String umessage) {
		this.umessage = umessage;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUjob() {
		return ujob;
	}

	public void setUjob(String ujob) {
		this.ujob = ujob;
	}

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String email) {
		this.uemail = email;
	}
	public java.sql.Date getUdate() {
		return udate;
	}
	public void setUdate(java.sql.Date date) {
		this.udate = date;
	}
}
