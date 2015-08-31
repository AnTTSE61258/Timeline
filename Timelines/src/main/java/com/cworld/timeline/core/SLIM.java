package com.cworld.timeline.core;

import java.util.ArrayList;

public class SLIM {
	// GENERAL
	public static final String ELEMENT_ITEM = "item";
	public static final String ITEM_title = "title";
	public static final String ITEM_description = "description";
	public static final String ITEM_pubDate = "pubDate";
	public static final String ITEM_link = "link";
	public static final String ITEM_guid = "guid";

	
	public static final String CHANNEL_VNEXPRESS = "VNEXPRESS";
	public static final String CHANNEL_KENH14 = "KENH14";
	
	// VNEXPRESS
	public static final String VNEXPRESS_TRANGCHU = "http://vnexpress.net/rss/tin-moi-nhat.rss";
	public static final String VNEXPRESS_THOISU = "http://vnexpress.net/rss/thoi-su.rss";
	public static final String VNEXPRESS_THEGIOI = "http://vnexpress.net/rss/the-gioi.rss";
	public static final String VNEXPRESS_KINHDOANH = "http://vnexpress.net/rss/kinh-doanh.rss";
	public static final String VNEXPRESS_GIAITRI = "http://vnexpress.net/rss/giai-tri.rss";
	public static final String VNEXPRESS_THETHAO = "http://vnexpress.net/rss/the-thao.rss";
	public static final String VNEXPRESS_PHAPLUAT = "http://vnexpress.net/rss/phap-luat.rss";
	public static final String VNEXPRESS_GIAODUC = "http://vnexpress.net/rss/giao-duc.rss";
	public static final String VNEXPRESS_SUCKHOE = "http://vnexpress.net/rss/suc-khoe.rss";
	public static final String VNEXPRESS_GIADINH = "http://vnexpress.net/rss/gia-dinh.rss";
	public static final String VNEXPRESS_DULICH = "http://vnexpress.net/rss/du-lich.rss";
	public static final String VNEXPRESS_KHOAHOC = "http://vnexpress.net/rss/khoa-hoc.rss";
	public static final String VNEXPRESS_SOHOA = "http://vnexpress.net/rss/so-hoa.rss";
	public static final String VNEXPRESS_OTO = "http://vnexpress.net/rss/oto-xe-may.rss";
	public static final String VNEXPRESS_CONGDONG = "http://vnexpress.net/rss/cong-dong.rss";
	public static final String VNEXPRESS_TAMSU = "http://vnexpress.net/rss/tam-su.rss";
	public static final String VNEXPRESS_CUOI = "http://vnexpress.net/rss/cuoi.rss";

	public static final String[] RSS_VNEXPRESS = { VNEXPRESS_TRANGCHU,
			VNEXPRESS_THOISU, VNEXPRESS_THEGIOI, VNEXPRESS_KINHDOANH,
			VNEXPRESS_GIAITRI, VNEXPRESS_THETHAO, VNEXPRESS_PHAPLUAT,
			VNEXPRESS_GIAODUC, VNEXPRESS_SUCKHOE, VNEXPRESS_GIADINH,
			VNEXPRESS_DULICH, VNEXPRESS_KHOAHOC, VNEXPRESS_SOHOA,
			VNEXPRESS_OTO, VNEXPRESS_CONGDONG, VNEXPRESS_TAMSU, VNEXPRESS_CUOI };

	// DANTRI
	public static final String DANTRI_TRANGCHU = "http://dantri.com.vn/trangchu.rss";
	public static final String DANTRI_SUCKHOE = "http://dantri.com.vn/suc-khoe.rss";
	public static final String DANTRI_XAHOI = "http://dantri.com.vn/xa-hoi.rss";
	public static final String DANTRI_GIAITRI = "http://dantri.com.vn/giai-tri.rss";
	public static final String DANTRI_GIAODUC = "http://dantri.com.vn/giao-duc-khuyen-hoc.rss";
	public static final String DANTRI_THETHAO = "http://dantri.com.vn/the-thao.rss";
	public static final String DANTRI_THEGIOI = "http://dantri.com.vn/the-gioi.rss";
	public static final String DANTRI_KINHDOANH = "http://dantri.com.vn/kinh-doanh.rss";
	public static final String DANTRI_OTO = "http://dantri.com.vn/o-to-xe-may.rss";
	public static final String DANTRI_SUCMANHSO = "http://dantri.com.vn/suc-manh-so.rss";
	public static final String DANTRI_TINHYEU = "http://dantri.com.vn/tinh-yeu-gioi-tinh.rss";
	public static final String DANTRI_CHUYENLA = "http://dantri.com.vn/chuyen-la.rss";
	public static final String DANTRI_NHIPSONGTRE = "http://dantri.com.vn/nhip-song-tre.rss";
	public static final String DANTRI_LONGNHANAI = "http://dantri.com.vn/tam-long-nhan-ai.rss";
	public static final String DANTRI_DOISONG = "http://dantri.com.vn/doi-song.rss";
	public static final String[] RSS_DANTRI = { DANTRI_TRANGCHU,
			DANTRI_SUCKHOE, DANTRI_XAHOI, DANTRI_GIAITRI, DANTRI_GIAODUC,
			DANTRI_THETHAO, DANTRI_THEGIOI, DANTRI_KINHDOANH, DANTRI_OTO,
			DANTRI_SUCMANHSO, DANTRI_TINHYEU, DANTRI_CHUYENLA,
			DANTRI_NHIPSONGTRE, DANTRI_LONGNHANAI, DANTRI_DOISONG };
	

	// KENH14
	public static final String KENH14_TRANGCHU = "http://kenh14.vn/trangchu.rss";
	public static final String KENH14_START = "http://kenh14.vn/star.rss";
	public static final String KENH14_MUSIZ = "http://kenh14.vn/musik.rss";
	public static final String KENH14_CINE = "http://kenh14.vn/cine.rss";
	public static final String KENH14_TVSHOW = "http://kenh14.vn/tv-show.rss";
	public static final String KENH14_FASHION = "http://kenh14.vn/fashion.rss";
	public static final String KENH14_DOISONG = "http://kenh14.vn/doi-song.rss";
	public static final String KENH14_XAHOI = "http://kenh14.vn/xa-hoi.rss";
	public static final String KENH14_THEGIOI = "http://kenh14.vn/the-gioi.rss";
	public static final String KENH14_SUCKHOEGIOITINH = "http://kenh14.vn/suc-khoe-gioi-tinh.rss";
	public static final String KENH14_MADEBYME = "http://kenh14.vn/made-by-me.rss";
	public static final String KENH14_SPORT = "http://kenh14.vn/sport.rss";
	public static final String KENH14_KHAMPHA = "http://kenh14.vn/kham-pha.rss";
	public static final String KENH14_HITEK = "http://kenh14.vn/2-tek.rss";
	public static final String KENH14_LACOOL = "http://kenh14.vn/la-cool.rss";
	public static final String KENH14_HOCDUONG = "http://kenh14.vn/hoc-duong.rss";

	public static final String[] RSS_KENH14 = { KENH14_TRANGCHU, KENH14_START,
			KENH14_MUSIZ, KENH14_CINE, KENH14_TVSHOW, KENH14_FASHION,
			KENH14_DOISONG, KENH14_XAHOI, KENH14_THEGIOI,
			KENH14_SUCKHOEGIOITINH, KENH14_MADEBYME, KENH14_SPORT,
			KENH14_KHAMPHA, KENH14_HITEK, KENH14_LACOOL, KENH14_HOCDUONG};

	public static final String[] vnexpressCategory = {"Trang Chu", "Thoi Su"};
	public static final String[] kenh14Category = {"Trang Chu","Star","Musiz"};
}


