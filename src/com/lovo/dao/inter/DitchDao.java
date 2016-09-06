package com.lovo.dao.inter;

import java.util.List;

import com.lovo.entity.Ditch;

public interface DitchDao {
	/**
	 * 查出渠道所有效信息、用到显示渠道信息的页面数据表格中
	 * @param ditch
	 * @return,
	 */
	public List<Ditch> checkDitch(Ditch ditch);
	/**
	 * 分页查询渠道信息
	 * @param ditch
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Ditch> showDitch(Ditch ditch,int pageNumber,int pageSize);
	/**
	 * 新增渠道
	 * @param d
	 */
	public void addDitch(Ditch d);
	/**
	 * 通过传入的ID删除渠道(假删除);
	 * @param id
	 */
	public void delecteDitch(int id);
	/**
	 * 通过ID查询所有渠道信息、
	 * @param ditch_id
	 * @return
	 */
	public Ditch selectDitch(int ditch_id);
	/**
	 * 修改渠道信息
	 * @param d
	 */
	public void modifyDitch(Ditch d);
}
