package com.lovo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Record implements Serializable{
	
	private int id;
	private int user_id;
	private int elient_id;
	private String progress;//跟踪进度
	private String progressInfo;//跟踪信息
	private String trackingDate;//跟踪时间
	private String returnDate;//回访时间
	public Record (){}
	public Record(int id, int userId, int elientId, String progress,
			String progressInfo, String trackingDate, String returnDate) {
		this.id = id;
		user_id = userId;
		elient_id = elientId;
		this.progress = progress;
		this.progressInfo = progressInfo;
		this.trackingDate = trackingDate;
		this.returnDate = returnDate;
	}
	/**
	 * 无主键构造器
	 * @param userId
	 * @param elientId
	 * @param progress
	 * @param progressInfo
	 * @param trackingDate
	 * @param returnDate
	 */
	public Record(int userId, int elientId, String progress,
			String progressInfo, String trackingDate, String returnDate) {
		user_id = userId;
		elient_id = elientId;
		this.progress = progress;
		this.progressInfo = progressInfo;
		this.trackingDate = trackingDate;
		this.returnDate = returnDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public int getElient_id() {
		return elient_id;
	}
	public void setElient_id(int elientId) {
		elient_id = elientId;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getProgressInfo() {
		return progressInfo;
	}
	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo;
	}
	public String getTrackingDate() {
		return trackingDate;
	}
	public void setTrackingDate(String trackingDate) {
		this.trackingDate = trackingDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
}
