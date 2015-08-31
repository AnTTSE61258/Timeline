package com.cworld.timeline.database.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Item {

	private int itemId;
	private String channel;
	private String category;
	private String seourl;
	private String title;
	private String description;
	private String pubDate;
	private String link;
	private String guid;
	private String desWithoutImage;
	private String smallImage;
	private Timestamp addDate;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int itemId, String channel, String category, String seourl, String title, String description,
			String pubDate, String link, String guid, Timestamp addDate) {
		this.itemId = itemId;
		this.channel = channel;
		this.category = category;
		this.seourl = seourl;
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link = link;
		this.guid = guid;
		this.addDate = addDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDesWithoutImage() {
		return desWithoutImage;
	}

	public void setDesWithoutImage(String desWithoutImage) {
		this.desWithoutImage = desWithoutImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Timestamp getAddDate() {
		return addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeourl() {
		return seourl;
	}

	public void setSeourl(String seourl) {
		this.seourl = seourl;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Item) obj).getSeourl().equals(this.seourl);
	}
	
	

}
