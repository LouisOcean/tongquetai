package com.lovo.servers.impl;

import java.util.List;

import com.lovo.dao.impl.DitchDaoImp;
import com.lovo.dao.inter.DitchDao;
import com.lovo.entity.Ditch;
import com.lovo.servers.inter.DitchInt;

public class DitchImp implements DitchInt{
	DitchDao ditchDao = new DitchDaoImp();
	/**
	 * 查出渠道所有效信息、用到显示渠道信息的页面数据表格中
	 * @param ditch
	 * @return,
	 */
	public List<Ditch> checkDitch(Ditch ditch) {
		return ditchDao.checkDitch(ditch);
	}
	/**
	 * 分页查询渠道信息
	 * @param ditch
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Ditch> showDitch(Ditch ditch,int pageNumber,int pageSize){
		return ditchDao.showDitch(ditch, pageNumber, pageSize);
	}
	/**
	 * 新增渠道
	 * @param d
	 */
	public void addDitch(Ditch d){
		ditchDao.addDitch(d);
	}
	/**
	 * 通过传入的ID删除渠道(假删除);
	 * @param id
	 */
	public void delecteDitch(int id){
		ditchDao.delecteDitch(id);
	}
	/**
	 * 通过ID查询所有渠道信息、
	 * @param ditch_id
	 * @return
	 */
	public Ditch selectDitch(int ditch_id){
		return ditchDao.selectDitch(ditch_id);
	}
	/**
	 * 修改渠道信息
	 * @param d
	 */
	public void modifyDitch(Ditch d){
		ditchDao.modifyDitch(d);
	}

}
