package com.cworld.timeline.getContent;

public class GetContent {
	public static String getContent(String url) throws Exception {
		String rawResponse = GetResponse.getRespone(url);
		return getModResponse(rawResponse, url);


	}

	private static String getModResponse(String rawResponse, String url) {
		String modResponse;
		if (url.contains("kenh14.vn")) {
			modResponse = ModResponseForKenh14.modResponse(rawResponse);
			return modResponse;
		}

		if (url.contains("vnexpress.net")) {
			modResponse = ModResponseForVnexpress.modResponse(rawResponse);
			return modResponse;
		}
		
		if (url.contains("dantri.com.vn")) {
			modResponse = ModResponseForDanTri.modResponse(rawResponse);
			return modResponse;
		}
		
		return null;

	}

}
