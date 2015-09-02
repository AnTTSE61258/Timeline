package com.cworld.timeline.category;

public class Category {
	String displayName;
	String cookie;
	String channel;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String displayName, String cookie, String channel) {
		this.displayName = displayName;
		this.cookie = cookie;
		this.channel = channel;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
