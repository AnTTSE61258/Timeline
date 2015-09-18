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
import javax.servlet.http.HttpServletResponse;

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
import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.generate.MGContentManager;
import com.cworld.timeline.getContent.GetContent;
import com.cworld.timeline.service.UpdateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SelectChannelController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	UpdateService updateService;
	@Autowired
	MGContentManager mgContentManager;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/selectchannel", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
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
		
		MGContentManager.addCategoryToModel(model);
		
		
		return "selectchannel";
	}


}
