package com.lovo.servers.impl;

import java.util.List;

import com.lovo.dao.impl.ElientDaoImp;
import com.lovo.dao.inter.ElientDao;
import com.lovo.entity.Elient;
import com.lovo.servers.inter.ElientInt;

public class ElientImp implements ElientInt{
	ElientDao elientDao = new ElientDaoImp();
	/**
	 * 显示所有客户信息
	 */
	public List<Elient> showCleint(Elient elient) {
		return elientDao.showCleint(elient);
	}
	/**
	 * 分页显示所有客户信息
	 * @param elient
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Elient> pageshowCleint(Elient elient,int pageNumber,int pageSize,String str){
		return elientDao.pageshowCleint(elient, pageNumber, pageSize, str);
	}
	/**
	 * 删除用户
	 * @param id
	 */
	public void delectElient(int id) {
		elientDao.delectElient(id);
		
	}

}
