package com.lovo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 对应数据库菜单表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Menu implements Serializable{
	private int id;
	private String m_name;
	private String url;
	private int parten_id; //父菜单id
	private List<Menu> submenu = new ArrayList<Menu>();
	public List<Menu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<Menu> submenu) {
		this.submenu = submenu;
	}

	public Menu(){}

	public Menu(int id, String mName, String url, int partenId) {
		this.id = id;
		m_name = mName;
		this.url = url;
		parten_id = partenId;
	}
	
	public Menu(String mName, String url, int partenId) {
		m_name = mName;
		this.url = url;
		parten_id = partenId;
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

	public int getParten_id() {
		return parten_id;
	}

	public void setParten_id(int partenId) {
		parten_id = partenId;
	}
	
	
}
