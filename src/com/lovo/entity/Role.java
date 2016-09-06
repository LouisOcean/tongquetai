package com.lovo.entity;

import java.io.Serializable;
/**
 * 对应数据库角色表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Role implements Serializable{
	private int id;
	private String roleName;
	public Role(){}
	public Role(int id,String roleName){
		this.id = id;
		this.roleName = roleName;
	}
	
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
