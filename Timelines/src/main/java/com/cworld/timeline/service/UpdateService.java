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

import com.cworld.timeline.category.SLIMCategory;
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
				System.out.println("Update Service is excuted at: " + new Date().toLocaleString());
				getAndSave(SLIM.CHANNEL_VNEXPRESS);
				getAndSave(SLIM.CHANNEL_KENH14);
				getAndSave(SLIM.CHANNEL_DANTRI);
			}
		});
		timer.setRepeats(true);
		timer.start();
		System.out.println("Update service is started at: " + new Date().toLocaleString());

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
			getAndSaveOneTarget(SLIM.VNEXPRESS_TRANGCHU, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_TrangChu.getCookie());
			// VNEXPRESS_THOISU
			getAndSaveOneTarget(SLIM.VNEXPRESS_THOISU, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_ThoiSu.getCookie());
			// VNEXPRESS_THEGIOI
			getAndSaveOneTarget(SLIM.VNEXPRESS_THEGIOI, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_TheGioi.getCookie());
			// VNEXPRESS_KINHDOANH
			getAndSaveOneTarget(SLIM.VNEXPRESS_KINHDOANH, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_KinhDoanh.getCookie());
			// VNEXPRESS_GIAITRI
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIAITRI, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_GiaiTri.getCookie());
			// VNEXPRESS_THETHAO
			getAndSaveOneTarget(SLIM.VNEXPRESS_THETHAO, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_TheThao.getCookie());
			// VNEXPRESS_PHAPLUAT
			getAndSaveOneTarget(SLIM.VNEXPRESS_PHAPLUAT, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_PhapLuat.getCookie());
			// VNEXPRESS_GIAODUC
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIAODUC, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_GiaoDuc.getCookie());
			// VNEXPRESS_SUCKHOE
			getAndSaveOneTarget(SLIM.VNEXPRESS_SUCKHOE, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_SucKhoe.getCookie());
			// VNEXPRESS_GIADINH
			getAndSaveOneTarget(SLIM.VNEXPRESS_GIADINH, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_GiaDinh.getCookie());
			// VNEXPRESS_KHOAHOC
			getAndSaveOneTarget(SLIM.VNEXPRESS_KHOAHOC, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_KhoaHoc.getCookie());
			// VNEXPRESS_DULICH
			getAndSaveOneTarget(SLIM.VNEXPRESS_DULICH, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_DuLich.getCookie());
			// VNEXPRESS_SOHOA
			getAndSaveOneTarget(SLIM.VNEXPRESS_SOHOA, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_SoHoa.getCookie());
			// VNEXPRESS_OTO
			getAndSaveOneTarget(SLIM.VNEXPRESS_OTO, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_Oto.getCookie());
			// VNEXPRESS_CONGDONG
			getAndSaveOneTarget(SLIM.VNEXPRESS_CONGDONG, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_CongDong.getCookie());
			// VNEXPRESS_CUOI
			getAndSaveOneTarget(SLIM.VNEXPRESS_CUOI, SLIM.CHANNEL_VNEXPRESS, SLIMCategory.vnexpress_Cuoi.getCookie());

			break;
		case SLIM.CHANNEL_KENH14:
			// ///KENH 14

			// KENH14_TRANGCHU
			getAndSaveOneTarget(SLIM.KENH14_TRANGCHU, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_TrangChu.getCookie());
			// KENH14_STAR
			getAndSaveOneTarget(SLIM.KENH14_START, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Star.getCookie());
			// KENH14_MUSIZ
			getAndSaveOneTarget(SLIM.KENH14_MUSIZ, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Musiz.getCookie());
			// KENH14_CINE
			getAndSaveOneTarget(SLIM.KENH14_CINE, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Cine.getCookie());
			// KENH14_TVSHOW
			getAndSaveOneTarget(SLIM.KENH14_TVSHOW, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_TVShow.getCookie());
			// KENH14_FASHION
			getAndSaveOneTarget(SLIM.KENH14_FASHION, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Fashion.getCookie());
			// KENH14_DOISONG
			getAndSaveOneTarget(SLIM.KENH14_DOISONG, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_DoiSong.getCookie());
			// KENH14_XAHOI
			getAndSaveOneTarget(SLIM.KENH14_XAHOI, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_XaHoi.getCookie());
			// KENH14_THEGIOI
			getAndSaveOneTarget(SLIM.KENH14_THEGIOI, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_TheGioi.getCookie());
			// KENH14_SUCKHOEGIOITINH
			getAndSaveOneTarget(SLIM.KENH14_SUCKHOEGIOITINH, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_SucKhoeGioiTinh.getCookie());
			// KENH14_MADEBYME
			getAndSaveOneTarget(SLIM.KENH14_MADEBYME, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_MadeByMe.getCookie());
			// KENH14_SPORT
			getAndSaveOneTarget(SLIM.KENH14_SPORT, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Sport.getCookie());
			// KENH14_KHAMPHA
			getAndSaveOneTarget(SLIM.KENH14_KHAMPHA, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_KhamPha.getCookie());
			// KENH14_HITEK
			getAndSaveOneTarget(SLIM.KENH14_HITEK, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_Hitek.getCookie());
			// KENH14_LACOOL
			getAndSaveOneTarget(SLIM.KENH14_LACOOL, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_LaCool.getCookie());
			// KENH14_HOCDUONG
			getAndSaveOneTarget(SLIM.KENH14_HOCDUONG, SLIM.CHANNEL_KENH14, SLIMCategory.kenh14_HocDuong.getCookie());

			break;
			
		case SLIM.CHANNEL_DANTRI:
			// DANTRI_TRANGCHU
			getAndSaveOneTarget(SLIM.DANTRI_TRANGCHU, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_TrangChu.getCookie());
			// DANTRI_SUCKHOE
			getAndSaveOneTarget(SLIM.DANTRI_SUCKHOE, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_SucKhoe.getCookie());
			// DANTRI_XAHOI
			getAndSaveOneTarget(SLIM.DANTRI_XAHOI, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_XaHoi.getCookie());
			// DANTRI_GIAITRI
			getAndSaveOneTarget(SLIM.DANTRI_GIAITRI, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_GiaiTri.getCookie());
			// DANTRI_GIAODUC
			getAndSaveOneTarget(SLIM.DANTRI_GIAODUC, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_GiaoDuc.getCookie());
			// DANTRI_THETHAO
			getAndSaveOneTarget(SLIM.DANTRI_THETHAO, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_TheThao.getCookie());
			// DANTRI_THEGIOI
			getAndSaveOneTarget(SLIM.DANTRI_THEGIOI, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_TheGioi.getCookie());
			// DANTRI_KINHDOANH
			getAndSaveOneTarget(SLIM.DANTRI_KINHDOANH, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_KinhDoanh.getCookie());
			// DANTRI_OTO
			getAndSaveOneTarget(SLIM.DANTRI_OTO, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_Oto.getCookie());
			// DANTRI_SUCMANHSO
			getAndSaveOneTarget(SLIM.DANTRI_SUCMANHSO, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_SucManhSo.getCookie());
			// DANTRI_TINHYEU
			getAndSaveOneTarget(SLIM.DANTRI_TINHYEU, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_TinhYeu.getCookie());
			// DANTRI_CHUYENLA
			getAndSaveOneTarget(SLIM.DANTRI_CHUYENLA, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_ChuyenLa.getCookie());
			// DANTRI_NHIPSONGTRE
			getAndSaveOneTarget(SLIM.DANTRI_NHIPSONGTRE, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_NhipSongTre.getCookie());
			// DANTRI_LONGNHANAI
			getAndSaveOneTarget(SLIM.DANTRI_LONGNHANAI, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_LongNhanAi.getCookie());
			// DANTRI_DOISONG
			getAndSaveOneTarget(SLIM.DANTRI_DOISONG, SLIM.CHANNEL_DANTRI, SLIMCategory.dantri_DoiSong.getCookie());
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
