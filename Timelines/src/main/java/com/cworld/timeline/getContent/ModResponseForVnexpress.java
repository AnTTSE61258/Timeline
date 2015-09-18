package com.cworld.timeline.getContent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ModResponseForVnexpress {
	public static String modResponse(String rawResponse) {
		String response;
		response = getMainContent(rawResponse);
		response = removeBlockTimerShare(response);
		response = removeBoxComment(response);
		response = removeBlockTag(response);
		response = removeRelateNews(response);
		response = removeXemNhieuNhat(response);
		response = removeTinLienQuan(response);
		response = removeFacebook(response);
		return response;
	}

	private static String getMainContent(String raw) {
		Document document = Jsoup.parse(raw);
		Elements divs = document.select("div#box_details_news");
		// ticket #17
		if (divs==null||divs.size()==0) {
			Elements videoDivs = document.select("div#video_top");
			for (Element div : videoDivs) {
				return div.html();
			}
		}
		// ticket #17
		for (Element div : divs) {
			return div.html();
		}
		return null;
	}
	
	private static String removeBlockTimerShare(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div.block_timer_share");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeBoxComment(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div#box_comment");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeRelateNews(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div#box_tinkhac_detail");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeBlockTag(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div.block_tag");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
		
	}

	private static String removeXemNhieuNhat(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div#box_xemnhieunhat");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeTinLienQuan(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div#box_tinlienquan");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeFacebook(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div.div-fbook");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
}
