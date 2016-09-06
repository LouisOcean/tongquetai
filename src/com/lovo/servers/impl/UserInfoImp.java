package com.lovo.servers.impl;


import java.util.List;


import com.lovo.dao.impl.UserInfoDaoImp;
import com.lovo.dao.inter.UserInfoDao;
import com.lovo.entity.UserInfo;
import com.lovo.servers.inter.UserInfoInt;

public class UserInfoImp implements UserInfoInt{
	UserInfoDao userDao = new UserInfoDaoImp();
	/**
	 * 判断用户登录
	 * @param userName
	 * @param userPasw
	 * @return
	 */
	public boolean userJudgeLogin(String userName, String userPasw) {
		return userDao.userJudgeLogin(userName, userPasw);
	}
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(UserInfo user) {
		userDao.addUser(user);
	}
	/**
	 * 删除用户
	 * @param id
	 */
	public void delectUser(int id) {
		userDao.delectUser(id);
		
	}
	/**
	 * 根据id查询用户信息、用在表单回填
	 * @param id
	 * @return
	 */
	public UserInfo getUserById(int id) {
		return userDao.getUserById(id);
	}
	/**
	 * 通过id修改用户信息
	 * @param id
	 */
	public void queryUserID(UserInfo user) {
		userDao.queryUserID(user);
		
	}
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo queryUserName(String userName) {
		
		return userDao.queryUserName(userName);
	}
	/**
	 * 查询所有用户、放入集合并返回、用到显示数据表格
	 * @param user
	 * @return,
	 */
	public List<UserInfo> selectUserInfo(UserInfo user) {
		
		return userDao.selectUserInfo(user);
	}
	/**
	 * 分页查询所有有效用户信息
	 * @param user
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<UserInfo> showUserInfo(UserInfo user, int pageNumber,int pageSize, String str) {
		return userDao.showUserInfo(user, pageNumber, pageSize, str);
	}

}
