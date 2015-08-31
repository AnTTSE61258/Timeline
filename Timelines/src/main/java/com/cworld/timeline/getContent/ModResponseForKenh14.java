package com.cworld.timeline.getContent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ModResponseForKenh14 {
	public static String modResponse(String rawResponse) {
		String response;
		response = getMainContent(rawResponse);
		response = removeDetailTopLike(response);
		response = removeBeforeAfterLightBox(response);
		response = removeRelatedNews(response);
		return response;

	}

	private static String getMainContent(String raw) {
		Document document = Jsoup.parse(raw);
		Elements divs = document.select("div.postpadding");
		for (Element div : divs) {
			return div.html();
		}
		return null;
	}

	private static String removeDetailTopLike(String raw) {
		Document document = Jsoup.parse(raw);
		Elements toplikes = document.select("div.details_top_like");
		for (Element toplike : toplikes) {
			toplike.remove();
		}
		return document.html();
	}

	private static String removeBeforeAfterLightBox(String raw) {
		Document document = Jsoup.parse(raw);
		Elements befores = document.select("div#beforeAfterLightBox");
		for (Element before : befores) {
			before.remove();
		}
		return document.html();

	}

	private static String removeRelatedNews(String raw) {
		Document document = Jsoup.parse(raw);
		Elements news = document.select("div.related-news");
		for (Element renew : news) {
			renew.remove();
		}
		return document.html();

	}
}
