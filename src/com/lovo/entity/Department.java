package com.lovo.entity;

import java.io.Serializable;
/**
 * 对应数据库部门表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Department implements Serializable{
	private int d_eptno;//部门ID
	private String d_name;//部门名
	private int manage_id;//部门主管ID
	private String d_describe;//部门描述
	private String deptState;//部门状态
	
	public Department(){}

	public Department(int dEptno, String dName, int manageId, String dDescribe,
			String deptState) {
		d_eptno = dEptno;
		d_name = dName;
		manage_id = manageId;
		d_describe = dDescribe;
		this.deptState = deptState;
	}
	/**
	 * 无主键构造器
	 * @param dName
	 * @param manageId
	 * @param dDescribe
	 * @param deptState
	 */
	public Department( String dName, int manageId, String dDescribe,
			String deptState) {
		d_name = dName;
		manage_id = manageId;
		d_describe = dDescribe;
		this.deptState = deptState;
	}

	public int getD_eptno() {
		return d_eptno;
	}

	public void setD_eptno(int dEptno) {
		d_eptno = dEptno;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String dName) {
		d_name = dName;
	}

	public int getManage_id() {
		return manage_id;
	}

	public void setManage_id(int manageId) {
		manage_id = manageId;
	}

	public String getD_describe() {
		return d_describe;
	}

	public void setD_describe(String dDescribe) {
		d_describe = dDescribe;
	}

	public String getDeptState() {
		return deptState;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}
	
}
