package com.lovo.dao.impl;

import java.util.List;

import util.JDBCUtil;

import com.lovo.dao.inter.DitchDao;
import com.lovo.entity.Ditch;

public class DitchDaoImp implements DitchDao{
	/**
	 * 查出渠道所有效信息、用到显示渠道信息的页面数据表格中
	 * @param ditch
	 * @return,
	 */
	@SuppressWarnings("unchecked")
	public List<Ditch> checkDitch(Ditch ditch) {
		String sql = "select * from ditch where ditchState='YES'";
		List<Ditch> list = (List<Ditch>)JDBCUtil.queryEntities(Ditch.class, sql);
		return list;
	}
	/**
	 * 分页查询渠道信息
	 * @param ditch
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Ditch> showDitch(Ditch ditch,int pageNumber,int pageSize){
		String sql = "select * from ditch where ditchState='YES' limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Ditch> list = (List<Ditch>)JDBCUtil.queryEntities(Ditch.class, sql);
		return list;
	}
	/**
	 * 新增渠道
	 * @param d
	 */
	public void addDitch(Ditch d){
		String sql = "insert into ditch(ditchInfo,ditchName,cost,beginTime,ditchState)values(?,?,?,?,?)";
		JDBCUtil.DMLOperate(sql, d.getDithInfo(),d.getDitchName(),d.getCost(),d.getBeginTime(),d.getDitchState());
	}
	/**
	 * 通过传入的ID删除渠道(假删除);
	 * @param id
	 */
	public void delecteDitch(int id){
		String sql = "UPDATE ditch set ditchState='NO' where ditch_id="+id;
		JDBCUtil.DMLOperate(sql);
	}
	/**
	 * 通过ID查询所有渠道信息、
	 * @param ditch_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Ditch selectDitch(int ditch_id){
		String sql = "select * from ditch where ditch_id=?";
		List<Ditch> listditch = (List<Ditch>)JDBCUtil.queryEntities(Ditch.class, sql, ditch_id);
		Ditch ditch = null;
		ditch = listditch.get(0);
		return ditch;
	}
	/**
	 * 修改渠道信息
	 * @param d
	 */
	public void modifyDitch(Ditch d){
		String sql = "updeta ditch set ditchInfo=?,ditchName=?,cost=?,beginTime=?,ditchState=? where ditch_id=?";
		JDBCUtil.DMLOperate(sql, d.getDithInfo(),d.getDitchName(),d.getCost(),d.getBeginTime(),d.getDitchState(),d.getDitch_id());
	}
}
