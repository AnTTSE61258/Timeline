package com.cworld.timeline.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cworld.timeline.database.model.ItemContent;

public class ItemContentDAOImpl implements ItemContentDAO {
	private SessionFactory sessionFactory;

	public ItemContentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addItemContent(ItemContent itemContent) {
		if (sessionFactory==null) {
			return;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(itemContent);
		
	}

	@Override
	@Transactional
	public List<ItemContent> getItemtContent(String seourl) {
		if (sessionFactory==null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM ItemContent WHERE seourl = :seourl");
		query.setParameter("seourl", seourl);
		List<ItemContent> itemContents = query.list();
		return 	itemContents;
		
	}


	
}
