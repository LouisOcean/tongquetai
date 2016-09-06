package com.lovo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role_Menu implements Serializable{
	private int id;
	private int r_id;
	private int m_id;
	
	public Role_Menu(){}

	public int getId() {
		return id;
	}

	public Role_Menu(int id, int rId, int mId) {
		this.id = id;
		r_id = rId;
		m_id = mId;
	}
	/**
	 * 无主键id构造器
	 * @param rId
	 * @param mId
	 */
	public Role_Menu(int rId, int mId) {
		r_id = rId;
		m_id = mId;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int rId) {
		r_id = rId;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int mId) {
		m_id = mId;
	}
}
