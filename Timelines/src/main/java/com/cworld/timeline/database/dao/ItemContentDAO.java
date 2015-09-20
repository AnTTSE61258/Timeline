package com.cworld.timeline.database.dao;

import java.util.List;

import com.cworld.timeline.database.model.ItemContent;


public interface ItemContentDAO {
	public void addItemContent(ItemContent itemContent);
	public List<ItemContent> getItemtContent(String seourl);
}
