package com.cworld.timeline.generate;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.ui.Model;

import com.cworld.timeline.category.SLIMCategory;
import com.cworld.timeline.core.SLIM;
import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.util.CookieUtil;

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

	public List<Item> getFirstItemWithCookie(int numberOfItem, Cookie[] cookies) {
		String vnexpressChn = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("vnexpress_chn")) {
					vnexpressChn = CookieUtil.getCookieValue(cookie);
				}
			}
		}
		List<Item> items = new ArrayList<Item>();
		int currentPosition = 0;
		if (vnexpressChn == null) {
			return null;
		}
		Item item;
		while (currentItems!=null && items.size() < numberOfItem && currentPosition < currentItems.size()) {
			item = currentItems.get(currentPosition);
			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_VNEXPRESS)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_KENH14)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_DANTRI)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			currentPosition++;

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

	
	public List<Item> getNextItemWithCookie(int numberOfItem, String nextPoint, Cookie[] cookies){
		String vnexpressChn = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("vnexpress_chn")) {
					vnexpressChn = CookieUtil.getCookieValue(cookie);
				}
			}
		}
		if (vnexpressChn == null) {
			return null;
		}
		
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
		
		int currentPosition = position - 1;
		Item item;
		while (items.size()<numberOfItem && currentPosition>0) {
			item = currentItems.get(currentPosition);
			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_VNEXPRESS)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_KENH14)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_DANTRI)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}
			currentPosition--;
		}
		return items;
	}
	
	public List<Item> getPreviousItemWithCookie(int numberOfItem, String previousPoint, Cookie[] cookies) {
		String vnexpressChn = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("vnexpress_chn")) {
					vnexpressChn = CookieUtil.getCookieValue(cookie);
				}
			}
		}
		if (vnexpressChn == null) {
			return null;
		}
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
		int currentPosition = position;
		Item item;
		while (items.size()<numberOfItem && currentPosition < currentItems.size()) {// 5_9 fix issue getPreviousItems

			item = currentItems.get(currentPosition);
			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_VNEXPRESS)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_KENH14)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}

			if (item.getChannel() != null && item.getChannel().equals(SLIM.CHANNEL_DANTRI)) {
				if (item.getCategory() != null && vnexpressChn.contains(item.getCategory())) {
					items.add(item);
				}
			}
			currentPosition++;

		}
		if (items != null && items.size() > 0) {
			items.remove(0);// fix duplicate item
		}

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
		for (int i = position - 1; i >= position - numberOfItem; i--) {
			items.add(currentItems.get(i));
		}
		return items;

	}
	
	public boolean hasNews(String nextPoint) {
		Item demoItem = new Item();
		demoItem.setSeourl(nextPoint);
		System.out.println(nextPoint);
		int position = currentItems.indexOf(demoItem);
		if (position <= 0) {
			return false;
		}
		
		return true;
	}

	public boolean refreshCurrentItems() {

		if (currentItems == null) {
			currentItems = itemDAO.getFirstItems(5000);
		} else {
			List<Item> tempItems = itemDAO.getFirstItems(5000);
			for (Item item : tempItems) {
				if (!currentItems.contains(item)) {
					currentItems.add(0, item);
				}

			}
		}
		return false;
	}

	public static void addCategoryToModel(Model model){
		model.addAttribute("vnexpressCategory", SLIMCategory.vnexpessCategory);
		model.addAttribute("kenh14Category", SLIMCategory.kenh14Category);
		model.addAttribute("dantriCategory", SLIMCategory.dantriCategory);
		
	}
	
}
