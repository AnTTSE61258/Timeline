package com.cworld.timeline;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.generate.MGContentManager;
import com.cworld.timeline.service.UpdateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ViewDetailController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	UpdateService updateService;
	@Autowired
	MGContentManager mgContentManager;

	private static final Logger logger = LoggerFactory.getLogger(ViewDetailController.class);
	public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/item/{seourl}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String home(Locale locale, Model model, @PathVariable("seourl") String seourl) {
		System.out.println("ViewDetails" + seourl);
		Item targetItem = itemDAO.findItemBySeourl(seourl);
		model.addAttribute("detailItem", targetItem);
		List<Item> items = mgContentManager.getFirstItem(20);
		model.addAttribute("items", items);
		return "home";
	}

}
