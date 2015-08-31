package com.cworld.timeline.generate;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Literal;

import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;

public class MGContentManager {
	ItemDAO itemDAO;

	public MGContentManager(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public static List<Item> currentItems = null;

	public List<Item> getCurrentItems() {
		return currentItems;
	}

	public List<Item> getFirstItem(int numberOfItem) {
		List<Item> items = new ArrayList<Item>();
		if (currentItems.size() < numberOfItem) {
			numberOfItem = currentItems.size();
		}
		for (int i = 0; i < numberOfItem; i++) {
			items.add(currentItems.get(i));
		}
		return items;

	}

	public List<Item> getPreviousItem(int numberOfItem, String previousPoint) {
		List<Item> items = new ArrayList<Item>();
		Item demoItem = new Item();
		demoItem.setSeourl(previousPoint);
		System.out.println(previousPoint);
		int position = currentItems.indexOf(demoItem);
		if (currentItems.size() < position + numberOfItem) {
			numberOfItem = currentItems.size() - position;
			if (numberOfItem <= 0) {
				return null;
			}
		}
		System.out.println(position);
		for (int i = position; i < position + numberOfItem; i++) {
			items.add(currentItems.get(i));
		}
		items.remove(0); // fix duplicate item
		return items;

	}

	public List<Item> getNextItem(int numberOfItem, String nextPoint) {
		List<Item> items = new ArrayList<Item>();
		Item demoItem = new Item();
		demoItem.setSeourl(nextPoint);
		System.out.println(nextPoint);
		int position = currentItems.indexOf(demoItem);
		if (position < 0) {
			return null;
		}
		if (position - numberOfItem < 0) {
			numberOfItem = position;
		}
		for (int i = position -1 ; i >= position - numberOfItem ; i--) {
			items.add(currentItems.get(i));
		}
		return items;

	}

	
	
	public boolean refreshCurrentItems() {

		if (currentItems == null) {
			currentItems = itemDAO.getFirstItems(100);
		} else {
			List<Item> tempItems = itemDAO.getFirstItems(100);
			for (Item item : tempItems) {
				if (!currentItems.contains(item)) {
					currentItems.add(0, item);
				}

			}
		}
		return false;
	}

}
