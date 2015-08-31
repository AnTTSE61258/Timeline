package com.cworld.timeline.database.dao;

import java.sql.Timestamp;
import java.util.List;

import com.cworld.timeline.database.model.Item;

public interface ItemDAO {
	public void addItem(Item item);
	public List<Item> getFirstItems(int numberOfItems);
	public List<Item> getPreviosItems(Timestamp fromTime, int numberOfItems);
	public Item findItemBySeourl(String seourl);
}
