package com.lovo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Elient implements Serializable{
	private int id;
	private int manke;//预约号
	private String e_name;
	private String e_sex;
	private String e_tel;
	private String e_source;//客户来源
	private String QQ;
	private String consultProduct;//咨询产品
	private String counselor;//质询师
	private String turnover;//首次成交金额
	private String totalMoney;//总金额
	private String detailedAddress;//详细地址
	private String arrivalDate;//预计到店时间
	private String revisitDays;//预计回访时间
	private String dataState;//数据是否有效
	
	
	
	public Elient(){}
	public Elient(int id, int manke, String eName, String eSex, String eTel,
			String eSource, String qQ, String consultProduct, String counselor,
			String turnover, String totalMoney, String detailedAddress,
			String arrivalDate, String revisitDays,String dataState) {
		this.id = id;
		this.manke = manke;
		e_name = eName;
		e_sex = eSex;
		e_tel = eTel;
		e_source = eSource;
		QQ = qQ;
		this.consultProduct = consultProduct;
		this.counselor = counselor;
		this.turnover = turnover;
		this.totalMoney = totalMoney;
		this.detailedAddress = detailedAddress;
		this.arrivalDate = arrivalDate;
		this.revisitDays = revisitDays;
		this.dataState = dataState;
	}
	/**
	 * 无主键构造器
	 * @param manke
	 * @param eName
	 * @param eSex
	 * @param eTel
	 * @param eSource
	 * @param qQ
	 * @param consultProduct
	 * @param counselor
	 * @param turnover
	 * @param totalMoney
	 * @param detailedAddress
	 * @param arrivalDate
	 * @param revisitDays
	 */
	public Elient(int manke, String eName, String eSex, String eTel,
			String eSource, String qQ, String consultProduct, String counselor,
			String turnover, String totalMoney, String detailedAddress,
			String arrivalDate, String revisitDays,String dataState) {
		this.manke = manke;
		e_name = eName;
		e_sex = eSex;
		e_tel = eTel;
		e_source = eSource;
		QQ = qQ;
		this.consultProduct = consultProduct;
		this.counselor = counselor;
		this.turnover = turnover;
		this.totalMoney = totalMoney;
		this.detailedAddress = detailedAddress;
		this.arrivalDate = arrivalDate;
		this.revisitDays = revisitDays;
		this.dataState = dataState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManke() {
		return manke;
	}
	public void setManke(int manke) {
		this.manke = manke;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String eName) {
		e_name = eName;
	}
	public String getE_sex() {
		return e_sex;
	}
	public void setE_sex(String eSex) {
		e_sex = eSex;
	}
	public String getE_tel() {
		return e_tel;
	}
	public void setE_tel(String eTel) {
		e_tel = eTel;
	}
	public String getE_source() {
		return e_source;
	}
	public void setE_source(String eSource) {
		e_source = eSource;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getConsultProduct() {
		return consultProduct;
	}
	public void setConsultProduct(String consultProduct) {
		this.consultProduct = consultProduct;
	}
	public String getCounselor() {
		return counselor;
	}
	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getRevisitDays() {
		return revisitDays;
	}
	public void setRevisitDays(String revisitDays) {
		this.revisitDays = revisitDays;
	}
	public String getDataState() {
		return dataState;
	}
	public void setDataState(String dataState) {
		this.dataState = dataState;
	}
	
}
