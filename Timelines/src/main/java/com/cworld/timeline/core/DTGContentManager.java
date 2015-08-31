package com.cworld.timeline.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jdom2.JDOMException;

public class DTGContentManager {

	public List<DTGItem> getAllRss(String[] channel) throws JDOMException, IOException {
		List<DTGItem> dtgItems = new ArrayList<DTGItem>();
		for (int i = 0; i < channel.length; i++) {
			dtgItems.addAll(new DTGRssReader(channel[i]).getDTGItemList());
		}
		System.out.println("DTGContentManager- " + "got " + dtgItems.size() + " items");
		return dtgItems;
	}
}
