package com.lovo.servers.impl;

import java.util.List;


import com.lovo.dao.impl.RecordDaoImp;
import com.lovo.dao.inter.RecordDao;
import com.lovo.entity.Record;
import com.lovo.entity.UserInfo;
import com.lovo.servers.inter.RecordInt;

public class RecordImp implements RecordInt{
	RecordDao recordDao = new RecordDaoImp();
	/**
	 * 查询所有跟踪进度信息
	 * @param record
	 * @return
	 */
	public List<Record> showRecord(Record record){
		return recordDao.showRecord(record);
	}
	/**
	 * 分页显示所有跟踪记录
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Record> showPageRecord(Record record,int pageNumber,int pageSize){
		
		return recordDao.showPageRecord(record, pageNumber, pageSize);
	}
	/**
	 * 添加跟踪记录
	 * @param record
	 */
	public void addRecord(Record record){
		recordDao.addRecord(record);
	}
	/**
	 * 在用户表查询质询师
	 * @param user
	 * @return
	 */
	public List<UserInfo> selectCounselor(UserInfo user){
		 return recordDao.selectCounselor(user);
	}
	/**
	 * 删除跟踪记录
	 * @param id
	 */
	public void deleteRecord(int id){
		recordDao.deleteRecord(id);
	}
	/**
	 * 回填表单信息
	 * @param id
	 * @return
	 */
	public Record backfillRecord(int id){
		return recordDao.backfillRecord(id);
	}
	/**
	 * 修改跟踪记录
	 * @param record
	 */
	public void modifyRecord(Record record){
		recordDao.modifyRecord(record);
	}
}
