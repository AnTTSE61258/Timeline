package com.cworld.timeline;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cworld.timeline.core.SLIM;
import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.generate.MGContentManager;
import com.cworld.timeline.getContent.GetContent;
import com.cworld.timeline.service.UpdateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	UpdateService updateService;
	@Autowired
	MGContentManager mgContentManager;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String home(Locale locale, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<Item> items = mgContentManager.getFirstItem(20);
		model.addAttribute("items", items);
		model.addAttribute("vnexpressCategory", SLIM.vnexpressCategory);
		model.addAttribute("kenh14Category", SLIM.kenh14Category);
		
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("vnexpress_chn")) {
		     System.out.println("OK men. I found my cookie");
		     System.out.println(URLDecoder.decode(cookie.getValue(), "UTF-8"));
		    }
		  }
		}
		
		return "home";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getContent(Locale locale, Model model) {
		System.setProperty("http.agent", USER_AGENT);
		updateService.startService();
		updateService.startUpdateCacheListService();
		return "home";
	}

	@RequestMapping(value = "/getFromDatabase", method = RequestMethod.GET)
	public String getFromDatabase(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		itemDAO.getFirstItems(10);

		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/getPrevious", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getPreviousItems(Locale locale, Model model, @RequestParam String previousPoint) {
		System.out.println("GET PREVIOUS FROM: " + previousPoint + ";");
		List<Item> previousItems = mgContentManager.getPreviousItem(9, previousPoint);
		// List<Item> previousItems = itemDAO.getPreviosItems(fromTimestamp, 2);
		for (int i = 0; i < previousItems.size(); i++) {
			System.out.println(previousItems.get(i).getAddDate());
		}
		return previousItems;
	}

	@RequestMapping(value = "/getNext", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getNextItems(Locale locale, Model model, @RequestParam String nextPoint) {
		System.out.println("GET NEXT FROM: " + nextPoint + ";");
		List<Item> nextItems = mgContentManager.getNextItem(9, nextPoint);
		return nextItems;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		List<Item> items = mgContentManager.getCurrentItems();
		model.addAttribute("items", items);
		return "admin";
	}

	@RequestMapping(value = "admin/admin-refresh", method = RequestMethod.GET)
	public String adminRefresh(Locale locale, Model model) {
		List<Item> items = mgContentManager.getCurrentItems();
		mgContentManager.refreshCurrentItems();
		model.addAttribute("items", items);
		return "admin";
	}

	@RequestMapping(value = "getTargetResponse", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getTargetResponse(Locale locale, Model model, @RequestParam String url) throws Exception {
		System.out.println("GET Target Response Url" + url);
		
		String response;
		try {
			response = GetContent.getContent(url);
		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}

		return response;
	}

}
