package com.lovo.dao.impl;

import java.util.List;

import util.JDBCUtil;

import com.lovo.dao.inter.RecordDao;
import com.lovo.entity.Record;
import com.lovo.entity.UserInfo;

public class RecordDaoImp implements RecordDao{
	/**
	 * 查询所有跟踪进度信息
	 * @param record
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Record> showRecord(Record record){
		String sql = "select * from record";
		List<Record> list = (List<Record>)JDBCUtil.queryEntities(Record.class, sql);
		return list;
	}
	/**
	 * 分页显示所有跟踪记录
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Record> showPageRecord(Record record,int pageNumber,int pageSize){
		String sql = "select * from record limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Record> list = (List<Record>)JDBCUtil.queryEntities(Record.class, sql);
		return list;
	}
	/**
	 * 添加跟踪记录
	 * @param record
	 */
	public void addRecord(Record record){
		String sql = "INSERT INTO record(user_id,elient_id,progress,progressInfo,trackingDate,returnDate) VALUES (?,?,?,?,?,?)";
		JDBCUtil.DMLOperate(sql,record.getUser_id(),record.getElient_id(),record.getProgress(),record.getProgressInfo(),record.getTrackingDate(),record.getReturnDate() );
	}
	/**
	 * 在用户表查询质询师
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> selectCounselor(UserInfo user){
		String sql = "SELECT * FROM USER WHERE role_id=3";
		 List<UserInfo> list = ( List<UserInfo>)JDBCUtil.queryEntities(UserInfo.class, sql);
		 return list;
	}
	/**
	 * 删除跟踪记录
	 * @param id
	 */
	public void deleteRecord(int id){
		String sql = "DELETE FROM record WHERE id = ?";
		JDBCUtil.DMLOperate(sql,id);
	}
	/**
	 * 回填表单信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Record backfillRecord(int id){
		Record record = null;
		String sql = "SELECT * FROM record WHERE id = ?";
		List<Record> list = (List<Record>)JDBCUtil.queryEntities(Record.class, sql, id);
		record = list.get(0);
		return record;
	}
	/**
	 * 修改跟踪记录
	 * @param record
	 */
	public void modifyRecord(Record record){
		String sql = "UPDATE record SET user_id=?,elient_id=?,progress=?,progressInfo=?,trackingDate=?,returnDate=? WHERE id = ?";
		JDBCUtil.DMLOperate(sql, record.getUser_id(),record.getElient_id(),record.getProgress(),record.getProgressInfo(),record.getTrackingDate(),record.getReturnDate(),record.getId());
	}
}
