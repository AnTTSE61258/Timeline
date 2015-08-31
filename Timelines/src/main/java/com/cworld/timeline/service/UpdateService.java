package com.cworld.timeline.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.swing.Timer;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;

import com.cworld.timeline.core.DTGItem;
import com.cworld.timeline.core.DTGRssReader;
import com.cworld.timeline.core.SLIM;
import com.cworld.timeline.database.dao.ItemDAO;
import com.cworld.timeline.database.model.Item;
import com.cworld.timeline.generate.MGContentManager;
import com.cworld.timeline.util.StringConverter;

public class UpdateService {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	MGContentManager contentManager;
	public boolean isRunning;
	private DTGRssReader dtgRssReader;

	public UpdateService() {
		System.out.println("Update Service is created");
		isRunning = false;
	}

	public void startService() {
		Timer timer = new Timer(60 * 1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Update Service is excuted at: "+new Date().toLocaleString());
				getAndSave(SLIM.CHANNEL_VNEXPRESS);
				getAndSave(SLIM.CHANNEL_KENH14);
			}
		});
		timer.setRepeats(true);
		timer.start();
		System.out.println("Update service is started at: "+new Date().toLocaleString());

	}

	public void startUpdateCacheListService() {
		javax.swing.Timer timera = new javax.swing.Timer(60 * 1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Update cache Service is excuted at" + new Date().toLocaleString());
				contentManager.refreshCurrentItems();
				
			}

		});
		timera.setRepeats(true);
		timera.start();
		System.out.println("Update cache service is started");
	}

	public class GetAndSaveAsyncTask implements Runnable {
		private String link;
		private String channel;
		private String category;

		public GetAndSaveAsyncTask() {
			// TODO Auto-generated constructor stub
		}

		public void setParams(String link, String channel, String category) {
			this.link = link;
			this.channel = channel;
			this.category = category;

		}

		@Override
		public void run() {
			DTGRssReader dtgRssReader = new DTGRssReader(link);
			try {
				List<DTGItem> dtgItems = dtgRssReader.getDTGItemList();
				Item item;
				for (DTGItem dtgItem : dtgItems) {
					item = new Item(0, channel, category, StringConverter.toPrettyURL(dtgItem.getTitle()), dtgItem.getTitle(),
							dtgItem.getDescription(), dtgItem.getPubDate(), dtgItem.getLink(), dtgItem.getGuid(), new Timestamp(
									new Date().getTime()));
					item.setSmallImage(StringConverter.toSmallImage(dtgItem.getDescription()));
					item.setDesWithoutImage(StringConverter.toRawDescription(dtgItem.getDescription()));
					itemDAO.addItem(item);
				}
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private void getAndSave(String channel) {
		switch (channel) {
		case SLIM.CHANNEL_VNEXPRESS:
			// VNEXPRESS_TRANGCHU
			getAndSaveOneTarget(SLIM.VNEXPRESS_TRANGCHU, SLIM.CHANNEL_VNEXPRESS, "TRANGCHU");
			// VNEXPRESS_THOISU
			getAndSaveOneTarget(SLIM.VNEXPRESS_THOISU, SLIM.CHANNEL_VNEXPRESS, "THOISU");
			// VNEXPRESS_THEGIOI
			getAndSaveOneTarget(SLIM.VNEXPRESS_THEGIOI, SLIM.CHANNEL_VNEXPRESS, "THEGIOI");
			// VNEXPRESS_KINHDOANH
			getAndSaveOneTarget(SLIM.VNEXPRESS_KINHDOANH, SLIM.CHANNEL_VNEXPRESS, "KINHDOANH");
			// VNEXPRESS_GIAITRI
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIAITRI, SLIM.CHANNEL_VNEXPRESS, "GIAITRI");
			// VNEXPRESS_THETHAO
			getAndSaveOneTarget(SLIM.VNEXPRESS_THETHAO, SLIM.CHANNEL_VNEXPRESS, "THETHAO");
			// VNEXPRESS_PHAPLUAT
			getAndSaveOneTarget(SLIM.VNEXPRESS_PHAPLUAT, SLIM.CHANNEL_VNEXPRESS, "PHAPLUAT");
			// VNEXPRESS_GIAODUC
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIAODUC, SLIM.CHANNEL_VNEXPRESS, "GIAODUC");
			// VNEXPRESS_SUCKHOE
			getAndSaveOneTarget(SLIM.VNEXPRESS_SUCKHOE, SLIM.CHANNEL_VNEXPRESS, "SUCKHOE");
			// VNEXPRESS_GIADINH
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIADINH, SLIM.CHANNEL_VNEXPRESS, "GIADINH");
			// VNEXPRESS_KHOAHOC
			getAndSaveOneTarget(SLIM.VNEXPRESS_KHOAHOC, SLIM.CHANNEL_VNEXPRESS, "KHOAHOC");
			// VNEXPRESS_DULICH
			getAndSaveOneTarget(SLIM.VNEXPRESS_DULICH, SLIM.CHANNEL_VNEXPRESS, "DULICH");
			// VNEXPRESS_SOHOA
			getAndSaveOneTarget(SLIM.VNEXPRESS_SOHOA, SLIM.CHANNEL_VNEXPRESS, "SOHOA");
			// VNEXPRESS_OTO
			getAndSaveOneTarget(SLIM.VNEXPRESS_OTO, SLIM.CHANNEL_VNEXPRESS, "OTO");
			// VNEXPRESS_CONGDONG
			getAndSaveOneTarget(SLIM.VNEXPRESS_CONGDONG, SLIM.CHANNEL_VNEXPRESS, "CONGDONG");
			// VNEXPRESS_CUOI
			getAndSaveOneTarget(SLIM.VNEXPRESS_CUOI, SLIM.CHANNEL_VNEXPRESS, "CUOI");

			break;
		case SLIM.CHANNEL_KENH14:
			// ///KENH 14

			// KENH14_TRANGCHU
			getAndSaveOneTarget(SLIM.KENH14_TRANGCHU, SLIM.CHANNEL_KENH14, "TRANGCHU");
			// KENH14_STAR
			getAndSaveOneTarget(SLIM.KENH14_START, SLIM.CHANNEL_KENH14, "STAR");
			// KENH14_MUSIZ
			getAndSaveOneTarget(SLIM.KENH14_MUSIZ, SLIM.CHANNEL_KENH14, "MUSIZ");
			// KENH14_CINE
			getAndSaveOneTarget(SLIM.KENH14_CINE, SLIM.CHANNEL_KENH14, "CINE");
			// KENH14_TVSHOW
			getAndSaveOneTarget(SLIM.KENH14_TVSHOW, SLIM.CHANNEL_KENH14, "TVSHOW");
			// KENH14_FASHION
			getAndSaveOneTarget(SLIM.KENH14_FASHION, SLIM.CHANNEL_KENH14, "FASHION");
			// KENH14_DOISONG
			getAndSaveOneTarget(SLIM.KENH14_DOISONG, SLIM.CHANNEL_KENH14, "DOISONG");
			// KENH14_XAHOI
			getAndSaveOneTarget(SLIM.KENH14_XAHOI, SLIM.CHANNEL_KENH14, "XAHOI");
			// KENH14_THEGIOI
			getAndSaveOneTarget(SLIM.KENH14_THEGIOI, SLIM.CHANNEL_KENH14, "THEGIOI");
			// KENH14_SUCKHOEGIOITINH
			getAndSaveOneTarget(SLIM.KENH14_SUCKHOEGIOITINH, SLIM.CHANNEL_KENH14, "SUCKHOEGIOITINH");
			// KENH14_MADEBYME
			getAndSaveOneTarget(SLIM.KENH14_MADEBYME, SLIM.CHANNEL_KENH14, "MADEBYME");
			// KENH14_SPORT
			getAndSaveOneTarget(SLIM.KENH14_SPORT, SLIM.CHANNEL_KENH14, "SPORT");
			// KENH14_KHAMPHA
			getAndSaveOneTarget(SLIM.KENH14_KHAMPHA, SLIM.CHANNEL_KENH14, "KHAMPHA");
			// KENH14_HITEK
			getAndSaveOneTarget(SLIM.KENH14_HITEK, SLIM.CHANNEL_KENH14, "HITEK");
			// KENH14_LACOOL
			getAndSaveOneTarget(SLIM.KENH14_LACOOL, SLIM.CHANNEL_KENH14, "LA_COOL");
			// KENH14_HOCDUONG
			getAndSaveOneTarget(SLIM.KENH14_HOCDUONG, SLIM.CHANNEL_KENH14, "HOCDUONG");

			break;
		default:
			break;
		}

	}

	private void getAndSaveOneTarget(String link, String channel, String category) {
		GetAndSaveAsyncTask getAndSaveAsyncTask = new GetAndSaveAsyncTask();
		getAndSaveAsyncTask.setParams(link, channel, category);
		getAndSaveAsyncTask.run();
	}

}
