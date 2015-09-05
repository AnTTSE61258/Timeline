package com.cworld.timeline.getContent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ModResponseForDanTri {
	public static String modResponse(String rawResponse) {
		String response;
		response = getMainContent(rawResponse);
		return response;
	}
	
	private static String getMainContent(String raw) {
		Document document = Jsoup.parse(raw);
		Elements divs = document.select("div#ctl00_IDContent_ctl00_divContent");
		for (Element div : divs) {
			return div.html();
		}
		return null;
	}

	
}
