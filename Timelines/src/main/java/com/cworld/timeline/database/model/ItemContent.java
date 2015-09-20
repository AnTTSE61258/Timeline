package com.cworld.timeline.database.model;

public class ItemContent {
	private String seourl;
	private String content;
	public String getSeourl() {
		return seourl;
	}
	public void setSeourl(String seourl) {
		this.seourl = seourl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ItemContent() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemContent(String seourl, String content) {
		super();
		this.seourl = seourl;
		this.content = content;
	}
	
}
