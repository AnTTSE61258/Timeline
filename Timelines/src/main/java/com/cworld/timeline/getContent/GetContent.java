package com.cworld.timeline.getContent;

import java.util.List;

import com.cworld.timeline.database.dao.ItemContentDAO;
import com.cworld.timeline.database.model.ItemContent;

public class GetContent {
	public static String getContent(ItemContentDAO itemContentDAO, String url,String seourl) throws Exception {
		if (url==null || url.equals("")) {
			return getContentWithSeoUrl(itemContentDAO, seourl);
		}
		
		String rawResponse = GetResponse.getRespone(url);
		return getModResponse(rawResponse, url);


	}
	
	private static String getContentWithSeoUrl(ItemContentDAO itemContentDAO, String seourl){
		List<ItemContent> itemContents =  itemContentDAO.getItemtContent(seourl);
		if (itemContents==null || itemContents.size()==0) {
			return "";
		}
		return itemContents.get(0).getContent();
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
