package com.lovo.entity;
/**
 * 对应数据库渠道表
 * @author Administrator
 *
 */
public class Ditch {
	private int ditch_id;//渠道主键
	private String dithInfo;//渠道信息
	private String ditchName;//渠道名
	private int cost;//成本
	private String beginTime;//开始时间
	private String ditchState;//渠道状态
	
	public Ditch(){}
	/**
	 * 全参构造器
	 * @param ditchId
	 * @param dithInfo
	 * @param ditchName
	 * @param cost
	 * @param beginTime
	 * @param ditchState
	 */
	public Ditch(int ditchId, String dithInfo, String ditchName, int  cost,
			String beginTime, String ditchState) {
		ditch_id = ditchId;
		this.dithInfo = dithInfo;
		this.ditchName = ditchName;
		this.cost = cost;
		this.beginTime = beginTime;
		this.ditchState = ditchState;
	}
	
	public Ditch(String dithInfo, String ditchName, int cost,
			String beginTime, String ditchState) {
		this.dithInfo = dithInfo;
		this.ditchName = ditchName;
		this.cost = cost;
		this.beginTime = beginTime;
		this.ditchState = ditchState;
	}

	public int getDitch_id() {
		return ditch_id;
	}

	public void setDitch_id(int ditchId) {
		ditch_id = ditchId;
	}

	public String getDithInfo() {
		return dithInfo;
	}

	public void setDithInfo(String dithInfo) {
		this.dithInfo = dithInfo;
	}

	public String getDitchName() {
		return ditchName;
	}

	public void setDitchName(String ditchName) {
		this.ditchName = ditchName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getDitchState() {
		return ditchState;
	}

	public void setDitchState(String ditchState) {
		this.ditchState = ditchState;
	}
	
}
