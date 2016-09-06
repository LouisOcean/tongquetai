package com.lovo.dao.inter;

import java.util.List;

import com.lovo.entity.Record;
import com.lovo.entity.UserInfo;

public interface RecordDao {
	/**
	 * 查询所有跟踪进度信息
	 * @param record
	 * @return
	 */
	public List<Record> showRecord(Record record);
	/**
	 * 分页显示所有跟踪记录
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Record> showPageRecord(Record record,int pageNumber,int pageSize);
	/**
	 * 添加跟踪记录
	 * @param record
	 */
	public void addRecord(Record record);
	/**
	 * 在用户表查询质询师
	 * @param user
	 * @return
	 */
	public List<UserInfo> selectCounselor(UserInfo user);
	/**
	 * 删除跟踪记录
	 * @param id
	 */
	public void deleteRecord(int id);
	/**
	 * 回填表单信息
	 * @param id
	 * @return
	 */
	public Record backfillRecord(int id);
	/**
	 * 修改跟踪记录
	 * @param record
	 */
	public void modifyRecord(Record record);
}
