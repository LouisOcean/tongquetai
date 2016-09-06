package com.lovo.entity;

import java.io.Serializable;
/**
 * 对应数据库用户信息表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserInfo implements Serializable{
	private int u_id;
	private int job;//工号
	private String userName;
	private String userPasw;
	private String realName;
	private String tel;
	private String userHead;//用户头像
	private String email;
	private String QQ;
	private String weChat;//微信
	private String urgency_name;//紧急联系人
	private String urgency_tel;//紧急联系人电话
	private int department_id;//部门id
	private String hiredate;//入职时间
	private String dataState;//数据是否有效
	private int role_id;//职位角色ID
	
	public UserInfo(){}

	public UserInfo(int uId, int job, String userName, String userPasw,
			String realName, String tel, String userHead, String email, String qQ,
			String weChat, String urgencyName, String urgencyTel,
			int departmentId, String hiredate, String dataState, int roleId) {
		this.u_id = uId;
		this.job = job;
		this.userName = userName;
		this.userPasw = userPasw;
		this.realName = realName;
		this.tel = tel;
		this.userHead = userHead;
		this.email = email;
		QQ = qQ;
		this.weChat = weChat;
		urgency_name = urgencyName;
		urgency_tel = urgencyTel;
		department_id = departmentId;
		this.hiredate = hiredate;
		this.dataState = dataState;
		role_id = roleId;
	}
	/**
	 * 
	 * 无id构造器
	 * @param job
	 * @param userName
	 * @param userPasw
	 * @param realName
	 * @param tel
	 * @param userHead
	 * @param email
	 * @param qQ
	 * @param weChat
	 * @param urgencyName
	 * @param urgencyTel
	 * @param departmentId
	 * @param hiredate
	 * @param dataState
	 * @param roleId
	 */
	public UserInfo(int job, String userName, String userPasw,
			String realName, String tel, String userHead, String email, String qQ,
			String weChat, String urgencyName, String urgencyTel,
			int departmentId, String hiredate, String dataState, int roleId) {
		this.job = job;
		this.userName = userName;
		this.userPasw = userPasw;
		this.realName = realName;
		this.tel = tel;
		this.userHead = userHead;
		this.email = email;
		QQ = qQ;
		this.weChat = weChat;
		urgency_name = urgencyName;
		urgency_tel = urgencyTel;
		department_id = departmentId;
		this.hiredate = hiredate;
		this.dataState = dataState;
		role_id = roleId;
	}
	public UserInfo(String userName, String userPasw) {
		this.userName = userName;
		this.userPasw = userPasw;
	}
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int uId) {
		u_id = uId;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasw() {
		return userPasw;
	}

	public void setUserPasw(String userPasw) {
		this.userPasw = userPasw;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getUrgency_name() {
		return urgency_name;
	}

	public void setUrgency_name(String urgencyName) {
		urgency_name = urgencyName;
	}

	public String getUrgency_tel() {
		return urgency_tel;
	}

	public void setUrgency_tel(String urgencyTel) {
		urgency_tel = urgencyTel;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int departmentId) {
		department_id = departmentId;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}
	
	
}
