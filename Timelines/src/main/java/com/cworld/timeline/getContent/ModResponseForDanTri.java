package com.cworld.timeline.getContent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ModResponseForDanTri {
	public static String modResponse(String rawResponse) {
		String response;
		response = getMainContent(rawResponse);
		response = removeNewsTag(response);
		//response = removeVCSortableInPreviewMode(response); If use this thing. Content can not display image
		return response;
	}
	
	private static String getMainContent(String raw) {
		Document document = Jsoup.parse(raw);
		Elements divs = document.select("div#ctl00_IDContent_ctl00_divContent");
		for (Element div : divs) {
			return div.outerHtml();
		}
		return null;
	}

	private static String removeNewsTag(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div.news-tag");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
	
	private static String removeVCSortableInPreviewMode(String raw){
		Document document = Jsoup.parse(raw);
		Elements blocks = document.select("div.VCSortableInPreviewMode");
		for (Element block : blocks) {
			block.remove();
		}
		return document.html();
	}
}
