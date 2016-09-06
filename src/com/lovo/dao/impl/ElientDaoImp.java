package com.lovo.dao.impl;

import java.util.List;

import util.JDBCUtil;

import com.lovo.dao.inter.ElientDao;
import com.lovo.entity.Elient;

public class ElientDaoImp implements ElientDao{
	/**
	 * 显示所有客户信息
	 */
	@SuppressWarnings("unchecked")
	public List<Elient> showCleint(Elient elient) {
		String sql = "SELECT * FROM elient WHERE dataState='YES'";
		List<Elient> list = (List<Elient>)JDBCUtil.queryEntities(Elient.class, sql);
		return list;
	}
	/**
	 * 分页显示所有客户信息
	 * @param elient
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Elient> pageshowCleint(Elient elient,int pageNumber,int pageSize,String str){
		String sql = "SELECT * FROM elient WHERE dataState='YES' "+str+" limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Elient> list = (List<Elient>)JDBCUtil.queryEntities(Elient.class, sql);
		return list;
	}
	/**
	 * 添加客户
	 * @param e
	 */
	public void addElient(Elient e){
		String sql = "INSERT INTO elient (manke,e_name,e_sex,e_tel,e_source,QQ,consultProduct,counselor,turnover,totalMoney,detailedAddress,arrivalDate,revisitDays,dataState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		JDBCUtil.DMLOperate(sql,e.getManke(),e.getE_name(),e.getE_sex(),e.getE_tel(),e.getE_source(),e.getQQ(),e.getConsultProduct(),e.getCounselor(),e.getTurnover(),e.getTotalMoney(),e.getDetailedAddress(),e.getArrivalDate(),e.getRevisitDays(),e.getDataState());
	}
	/**
	 * 删除客户
	 * @param id
	 */
	public void delectElient(int id) {
		JDBCUtil.DMLOperate("update elient set dataState='NO' where id in("+id+")");
		
	}
}
