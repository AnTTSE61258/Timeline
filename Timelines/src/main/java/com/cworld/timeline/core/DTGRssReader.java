package com.cworld.timeline.core;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class DTGRssReader {
	private String url;
	
	public DTGRssReader(String url) {
		this.url = url;
	}

	public Document buildDocument() throws JDOMException, IOException {
		Document document = null;
		SAXBuilder builder = new SAXBuilder();
		document = builder.build(url);
		return document;
	}

	private Element getRootElement() throws JDOMException, IOException {
		return buildDocument().getRootElement();
	}

	private Element getChannelElement() throws JDOMException, IOException {
		return getRootElement().getChildren().get(0); // Because root has only 1
														// child
	}

	private List<Element> getItemList() throws JDOMException, IOException {
		List<Element> channelChildren = getChannelElement().getChildren();
		// Get All item in channelChildren and remove items that is not ELEMENT_ITEM
		for (int i = channelChildren.size() - 1; i >= 0; i--) {
			if (!channelChildren.get(i).getName().equals(SLIM.ELEMENT_ITEM)) {
				channelChildren.remove(i);
			}
		}
		return channelChildren;
	}
	
	public List<DTGItem> getDTGItemList() throws JDOMException, IOException{
		List<Element> itemElements = getItemList();  
		List<DTGItem> dtgItems =new ArrayList<DTGItem>();
		for (int i = 0; i < itemElements.size(); i++) {
			dtgItems.add(parseElementToDTGItem(itemElements.get(i)));
		}
		return dtgItems;
		
	}
	
	private static DTGItem parseElementToDTGItem(Element itemElement){
		String title = itemElement.getChildText(SLIM.ITEM_title);
		String description = itemElement.getChildText(SLIM.ITEM_description);
		String pubDate = itemElement.getChildText(SLIM.ITEM_pubDate);
		String link = itemElement.getChildText(SLIM.ITEM_link);
		String guid = itemElement.getChildText(SLIM.ITEM_guid);
		return new DTGItem(title,description,pubDate,link,guid);
	}

}
