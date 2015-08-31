package com.cworld.timeline.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;

import com.cworld.timeline.HomeController;

public class GetResponse {

	public static String getRespone(String url) throws Exception {
		InputStream inputStream = null;
		if (url == null || url.equals("")) {
			return "";
		}
		url = url.trim();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", HomeController.USER_AGENT);

		int responseCode = con.getResponseCode();
		inputStream = con.getInputStream();
		Reader reader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader in = new BufferedReader(reader);
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();

	}

	public static void main(String[] args) throws Exception {
		String body = GetResponse
				.getRespone("http://kinhdoanh.vnexpress.net/tin-tuc/doanh-nghiep/thu-tuong-yeu-cau-luong-truoc-kich-ban-xau-voi-nen-kinh-te-3269567.html");
		System.out.println(body);
	}
}
