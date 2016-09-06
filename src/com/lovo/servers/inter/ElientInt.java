package com.lovo.servers.inter;

import java.util.List;

import com.lovo.entity.Elient;

public interface ElientInt {
	/**
	 * 查询显示所有客户信息，
	 * @param elient
	 * @return
	 */
	public List<Elient> showCleint(Elient elient);
	/**
	 * 分页显示所有客户信息
	 * @param elient
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Elient> pageshowCleint(Elient elient,int pageNumber,int pageSize,String str);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void delectElient(int id);
}
