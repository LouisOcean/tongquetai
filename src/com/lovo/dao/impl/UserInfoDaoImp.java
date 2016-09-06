package com.lovo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JBUtil;
import util.JDBCUtil;

import com.lovo.dao.inter.UserInfoDao;
import com.lovo.entity.UserInfo;

public class UserInfoDaoImp implements UserInfoDao{
	/**
	 * 判断用户登录
	 * @param userName
	 * @param userPasw
	 * @return
	 */
	public boolean userJudgeLogin(String userName, String userPasw) {
		boolean b = false;
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		@SuppressWarnings("unused")
		UserInfo user = null;
		try {
			String sql = "select * from user where userName = ? and userPasw = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPasw);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new UserInfo(userName,userPasw);
				b = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(rs, ps, con);
		}
		return b;
	}
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(UserInfo user) {
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO USER(job,userName,userPasw,realName,tel,userHead,email,QQ,weChat,urgency_name,urgency_tel,department_id,hiredate,dataState,role_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getJob());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserPasw());
			ps.setString(4, user.getRealName());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getUserHead());
			ps.setString(7, user.getEmail());
			ps.setString(8,user.getQQ());
			ps.setString(9, user.getWeChat());
			ps.setString(10, user.getUrgency_name());
			ps.setString(11, user.getUrgency_tel());
			ps.setInt(12, user.getDepartment_id());
			ps.setString(13, user.getHiredate());
			ps.setString(14, user.getDataState());
			ps.setInt(15, user.getRole_id());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(null, ps, con);
		}
	}
	/**
	 * 删除用户
	 * @param id
	 */
	public void delectUser(int id) {
		JDBCUtil.DMLOperate("update user set dataState='NO' where u_id in("+id+")");
		
	}
	/**
	 * 根据id查询用户信息、用在表单回填
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public UserInfo getUserById(int id) {
		UserInfo user = null;
		List<UserInfo> list = (List<UserInfo>)JDBCUtil.queryEntities(UserInfo.class, "select * from user where u_id=?", id);
		user = list.get(0);
		return user;
	}
	/**
	 * 通过id修改用户信息
	 * @param id
	 */
	public void queryUserID(UserInfo user) {
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "update user set job=?,userName=?,userPasw=?,realName=?,tel=?,userHead=?,email=?,QQ=?,weChat=?,urgency_name=?,urgency_tel=?,department_id=?,hiredate=?,dataState=?,role_id=? where u_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getJob());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserPasw());
			ps.setString(4, user.getRealName());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getUserHead());
			ps.setString(7, user.getEmail());
			ps.setString(8,user.getQQ());
			ps.setString(9, user.getWeChat());
			ps.setString(10, user.getUrgency_name());
			ps.setString(11, user.getUrgency_tel());
			ps.setInt(12, user.getDepartment_id());
			ps.setString(13, user.getHiredate());
			ps.setString(14, user.getDataState());
			ps.setInt(15, user.getRole_id());
			ps.setInt(16, user.getU_id());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(null, ps, con);
		}
		
	}
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo queryUserName(String userName) {
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo user = null;
		try {
			String sql = "select * from user where userName = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()){
				 user = new UserInfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						 rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),
						 rs.getString(14),rs.getString(15),rs.getInt(16));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(rs, ps, con);
		}
		return user;
	}
	/**
	 * 查询所有用户、放入集合并返回、用到显示数据表格
	 * @param user
	 * @return,
	 */
	public List<UserInfo> selectUserInfo(UserInfo user) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where dataState='YES'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				 user = new UserInfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						 rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),
						 rs.getString(14),rs.getString(15),rs.getInt(16));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(rs, ps, con);
		}
		return list;
	}
	/**
	 * 分页查询所有有效用户信息
	 * @param user
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> showUserInfo(UserInfo user, int pageNumber,
			int pageSize, String str) {
		String sql = "select * from user where dataState='YES' "+str+" limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<UserInfo> listuser = (List<UserInfo>)JDBCUtil.queryEntities(UserInfo.class, sql);
		return listuser;
	}
}
