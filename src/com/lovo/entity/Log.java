package com.lovo.entity;

import java.io.Serializable;
/**
 * 对应数据库log/日志表、
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Log implements Serializable{
	
	private int l_id;
	private int operator_id;//操作员id
	private String content;//内容
	private String detail;//详细内容
	private String operation_time;//操作时间
	
	public Log(){}

	public Log(int lId, int operatorId, String content, String detail,
			String operationTime) {
		l_id = lId;
		operator_id = operatorId;
		this.content = content;
		this.detail = detail;
		operation_time = operationTime;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int lId) {
		l_id = lId;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operatorId) {
		operator_id = operatorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(String operationTime) {
		operation_time = operationTime;
	}
	
	
	
}
