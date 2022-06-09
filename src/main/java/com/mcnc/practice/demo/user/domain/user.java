package com.mcnc.practice.demo.user.domain;

public class user {
 	private int USER_NO;
    private String USER_ID;
    private String USER_PW;
    private String USER_NAME;
    private String USER_AUTH;
    
	public int getUSER_NO() {
		return USER_NO;
	}
	public void setUSER_NO(int uSER_NO) {
		USER_NO = uSER_NO;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_AUTH() {
		return USER_AUTH;
	}
	public void setUSER_AUTH(String uSER_AUTH) {
		USER_AUTH = uSER_AUTH;
	}
	@Override
	public String toString() {
		return "user [USER_NO=" + USER_NO + ", USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_NAME=" + USER_NAME
				+ ", USER_AUTH=" + USER_AUTH + "]";
	}
	
    
}
