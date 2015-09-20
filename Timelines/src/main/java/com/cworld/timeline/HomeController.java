package com.cworld.timeline;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.TTCCLayout;
import org.hibernate.cache.spi.GeneralDataRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cworld.timeline.category.SLIMCategory;
import com.cworld.timeline.core.SLIM;
import com.cworld.timeline.database.dao.ItemContentDAO;
import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.database.model.ItemContent;
import com.cworld.timeline.generate.MGContentManager;
import com.cworld.timeline.getContent.GetContent;
import com.cworld.timeline.service.UpdateService;
import com.cworld.timeline.util.StringConverter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	ItemContentDAO itemContentDAO;
	@Autowired
	UpdateService updateService;
	@Autowired
	MGContentManager mgContentManager;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			Cookie defaultCookie = new Cookie("vnexpress_chn", SLIMCategory.vnexpress_TrangChu.getCookie() + ","
					+ SLIMCategory.kenh14_TrangChu.getCookie() + "," + SLIMCategory.dantri_TrangChu.getCookie());
			response.addCookie(defaultCookie);
			cookies = new Cookie[1];
			cookies[0] = defaultCookie;
		}
		List<Item> items = mgContentManager.getFirstItemWithCookie(20, cookies);
		model.addAttribute("items", items);
		MGContentManager.addCategoryToModel(model);
		// Check item parameter
		String item = request.getParameter("item");
		if (item != null) {
			System.out.println("View detail: " + item);
			Item targetItem = itemDAO.findItemBySeourl(item);
			model.addAttribute("detailItem", targetItem);
		}
		return "home";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getContent(Locale locale, Model moßdel) {
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
	public List<Item> getPreviousItems(Locale locale, Model model, @RequestParam String previousPoint, HttpServletRequest request) {
		System.out.println("GET PREVIOUS FROM: " + previousPoint + ";");
		Cookie[] cookies = request.getCookies();
		// List<Item> previousItems = mgContentManager.getPreviousItem(9,
		// previousPoint);
		List<Item> previousItems = mgContentManager.getPreviousItemWithCookie(9, previousPoint, cookies);
		for (int i = 0; i < previousItems.size(); i++) {
			System.out.println(previousItems.get(i).getAddDate());
		}
		return previousItems;
	}

	@RequestMapping(value = "/getNext", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getNextItems(Locale locale, Model model, @RequestParam String nextPoint, HttpServletRequest request) {
		System.out.println("GET NEXT FROM: " + nextPoint + ";");
		Cookie[] cookies = request.getCookies();
		List<Item> nextItems = mgContentManager.getNextItemWithCookie(10, nextPoint, cookies);
		return nextItems;
	}

	@RequestMapping(value = "/hasNews", method = RequestMethod.GET)
	@ResponseBody
	public boolean checknews(Locale locale, Model model, @RequestParam String nextPoint) {
		System.out.println("CHECK NEWS FROM: " + nextPoint + ";");
		boolean hasNews = mgContentManager.hasNews(nextPoint);
		return hasNews;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		List<Item> items = mgContentManager.getCurrentItems();
		model.addAttribute("items", items);
		model.addAttribute("getRssTimer", updateService.getTimerStatus(SLIM.TIMER_NAME_GET_RSS));
		model.addAttribute("generateTimer", updateService.getTimerStatus(SLIM.TIMER_NAME_GENERATE_CACHE));
		return "admin";
	}

	@RequestMapping(value = "admin/control", method = RequestMethod.POST)
	public String adminRefresh(Locale locale, Model model, HttpServletRequest request) {
		String btn = request.getParameter("btnControl");
		if (btn.equals("START SERVICE")) {
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+7:00"));
			System.setProperty("http.agent", USER_AGENT);
			updateService.startService();
			updateService.startUpdateCacheListService();
		}
		if (btn.equals("STOP SERVICE")) {
			updateService.stopAll();
		}
		if (btn.equals("GENERATE CACHE")) {
			mgContentManager.refreshCurrentItems();
		}
		if (btn.equals("CLEAR CACHE")) {
			mgContentManager.clearCurrentItems();

		}
		return "redirect:" + "/admin";
	}

	@RequestMapping(value = "getTargetResponse", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getTargetResponse(Locale locale, Model model, @RequestParam String url,
			@RequestParam(defaultValue="",required=false) String seourl) throws Exception {
		System.out.println("getTargetResponse" + seourl);
		String response;
		try {
			response = GetContent.getContent(itemContentDAO,url,seourl);
		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}

		return response;
	}

	@RequestMapping(value = "/postNew", method = RequestMethod.GET)
	public String postNew(Locale locale, Model model) {
		return "postNew";
	}

	@RequestMapping(value = "/post-new", method = RequestMethod.POST)
	public String post(Locale locale, Model model, HttpServletRequest request) {
		Item item;
		ItemContent itemContent;
		String title = request.getParameter("txtTitle");
		String seourl = StringConverter.toPrettyURL(title);
		String description = request.getParameter("txtDescription");
		String content = request.getParameter("content");
		String imageUrl = request.getParameter("txtImageUrl");
		item = new Item(0, SLIM.CHANNEL_CUSTOM, SLIM.CHANNEL_CUSTOM, seourl, title, description, "", "", "", new Timestamp(
				new Date().getTime()));
		item.setSmallImage(imageUrl);
		item.setDesWithoutImage(description);
		itemContent = new ItemContent(seourl, content);
		if (itemDAO.findItemBySeourl(seourl)==null) {
			itemDAO.addItem(item);
		}
		if (itemContentDAO.getItemtContent(seourl)==null || itemContentDAO.getItemtContent(seourl).size()==0) {
			itemContentDAO.addItemContent(itemContent);
		}
		return "postNew";
	}
}
