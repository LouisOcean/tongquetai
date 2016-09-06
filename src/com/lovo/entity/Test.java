package com.lovo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Test implements Serializable{
	private int id ;
	private String m_name;
	private String url;
	private int parent_id;
	private int role_id;
	private int r_id;
	private int m_id;
	
	public Test(){}

	public Test(int id, String mName, String url, int parentId, int roleId,
			int rId, int mId) {
		this.id = id;
		m_name = mName;
		this.url = url;
		parent_id = parentId;
		role_id = roleId;
		r_id = rId;
		m_id = mId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String mName) {
		m_name = mName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parentId) {
		parent_id = parentId;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
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
