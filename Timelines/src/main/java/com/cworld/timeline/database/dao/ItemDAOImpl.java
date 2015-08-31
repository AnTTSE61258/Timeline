package com.cworld.timeline.database.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.util.StringConverter;

public class ItemDAOImpl implements ItemDAO {
	private SessionFactory sessionFactory;

	public ItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addItem(Item item) {
		if (sessionFactory == null) {
			return;
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Item WHERE seourl = :seourl");
		query.setParameter("seourl", StringConverter.toPrettyURL(item.getTitle()));
		List<Item> items = query.list();
		if (items.size() > 0) {
			return;
		}
		session.save(item);

	}

	@Override
	@Transactional
	public List<Item> getFirstItems(int numberOfItems) {
		List<Item> items = null;
		if (sessionFactory == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Item ORDER BY addDate DESC");
		query.setMaxResults(numberOfItems);
		items = query.list();
		System.out.println("Got " + numberOfItems + " from database");
		return items;
	}

	@Override
	@Transactional
	public List<Item> getPreviosItems(Timestamp fromTime, int numberOfItems) {
		List<Item> items = null;
		if (sessionFactory == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Item  WHERE addDate < :time ORDER BY addDate DESC");
		query.setTimestamp("time", fromTime);
		query.setMaxResults(numberOfItems);
		items = query.list();
		return items;
	}

	@Override
	@Transactional
	public Item findItemBySeourl(String seourl) {
		Item item = null;
		if (sessionFactory == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Item WHERE seourl = :seourl");
		query.setParameter("seourl", seourl);
		List<Item> tmpItems = query.list();
		if (tmpItems==null || tmpItems.size()==0) {
			return null;
		}
		return tmpItems.get(0);
	}

}
