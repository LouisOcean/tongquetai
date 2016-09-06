package com.lovo.entity;

import java.io.Serializable;
/**
 * 对应数据库product/产品表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable{

	private int p_id;
	private String p_name;//产品名称
	private String recommendDoctor;//推荐医生
	private String p_describe;//产品描述
	private String createTime;//创建时间
	private String p_state;//产品是否有效
	
	public Product(){}

	public Product(int pId, String pName, String recommendDoctor,
			String pDescribe, String createTime, String pState) {
		p_id = pId;
		p_name = pName;
		this.recommendDoctor = recommendDoctor;
		p_describe = pDescribe;
		this.createTime = createTime;
		p_state = pState;
	}
	/**
	 * 无主键构造器
	 * @param pName
	 * @param recommendDoctor
	 * @param pDescribe
	 * @param createTime
	 * @param pState
	 */
	public Product(String pName, String recommendDoctor,
			String pDescribe, String createTime, String pState) {
		p_name = pName;
		this.recommendDoctor = recommendDoctor;
		p_describe = pDescribe;
		this.createTime = createTime;
		p_state = pState;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int pId) {
		p_id = pId;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String pName) {
		p_name = pName;
	}

	public String getRecommendDoctor() {
		return recommendDoctor;
	}

	public void setRecommendDoctor(String recommendDoctor) {
		this.recommendDoctor = recommendDoctor;
	}

	public String getP_describe() {
		return p_describe;
	}

	public void setP_describe(String pDescribe) {
		p_describe = pDescribe;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getP_state() {
		return p_state;
	}

	public void setP_state(String pState) {
		p_state = pState;
	}
	
}
