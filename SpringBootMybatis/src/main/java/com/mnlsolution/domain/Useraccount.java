package com.mnlsolution.domain;

import java.util.Date;

public class Useraccount {
	
	private long useridx; 
	private String loginid;
	private String passwd;
	private String email;
	private String username;	
	private Date regdate;
	private Date upddate;
	
	public String getLoginId() {
		return loginid;
	}
	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUseridx() {
		return useridx;
	}
	public void setUseridx(long useridx) {
		this.useridx = useridx;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpddate() {
		return upddate;
	}
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}
	@Override
	public String toString() {
		return "Useraccount [useridx=" + useridx + ", loginid=" + loginid + ", passwd=" + passwd + ", email=" + email
				+ ", username=" + username + ", regdate=" + regdate + ", upddate=" + upddate + "]";
	}
	
	
	
	
	
	

}
