package com.cworld.timeline.util;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConverter {
	public static final String TO_SMALL_IMAGE_PATTERN = "(.+?)<img(.+?)src=(.+?)(jpg|png|JPG|PNG|jpeg|gif)(.+?)( )";
	public static final String TO_RAW_DESCRIPTION = "(.+?)<img(.+?)/>(.+?)";
	public static String toPrettyURL(String string) {
		return Normalizer.normalize(string.toLowerCase(), Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.replaceAll("[^\\p{Alnum}]+", "-");
	}

	public static String toSmallImage(String string) {
		final Pattern pattern = Pattern.compile(TO_SMALL_IMAGE_PATTERN);
		final Matcher matcher = pattern.matcher(string);
		
		if (!matcher.find()) {
			System.out.println("Can't find small image");
			return null;
		}
		String result = "";
		try {
			result += matcher.group(3) + matcher.group(4) + matcher.group(5);
			result.replaceAll("'", "\"");
		} catch (Exception e) {
			System.out.println("parse to small image: "
					+ e.getLocalizedMessage());
		}
		return result;
	}

	
	public static String toRawDescription(String string) {
		return string.replaceAll("<img(.+?)>", "").replaceAll("'", "\"");
	}

	public static void main(String[] args) {
		String testString = " <a href='http://kenh14.vn/tv-show/thi-sinh-next-top-model-my-hoang-loan-vi-treo-minh-tren-khong-20150819125414216.chn'><img src='http://k14.vcmedia.vn/7939f58cb1/2015/08/19/ava-b847a.png' width='100' border='0' style=\"margin-right:10px;float:left; width:100px\" /></a><span>Không chỉ ở Việt Nam, mà các thí sinh \"Next Top Model\" của Mỹ cũng \"điêu đứng\" trước thử thách trên không, đặc biệt trong tập 3 mùa 22 tới đây.</span> ";
		System.out.println(toSmallImage(testString));
			
	}
}
