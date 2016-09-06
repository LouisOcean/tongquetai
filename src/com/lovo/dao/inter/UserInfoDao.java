package com.lovo.dao.inter;

import java.util.List;

import com.lovo.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * 判断用户登录
	 * @param userName
	 * @param userPasw
	 * @return
	 */
	public boolean userJudgeLogin(String userName, String userPasw);
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(UserInfo user);
	/**
	 * 删除用户
	 * @param id
	 */
	public void delectUser(int id);
	/**
	 * 根据id查询用户信息、用在表单回填
	 * @param id
	 * @return
	 */
	public UserInfo getUserById(int id) ;
	/**
	 * 通过id修改用户信息
	 * @param id
	 */
	public void queryUserID(UserInfo user);
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo queryUserName(String userName);
	/**
	 * 查询所有用户、放入集合并返回、用到显示数据表格
	 * @param user
	 * @return,
	 */
	public List<UserInfo> selectUserInfo(UserInfo user);
	/**
	 * 分页查询所有有效用户信息
	 * @param user
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<UserInfo> showUserInfo(UserInfo user, int pageNumber,int pageSize, String str);
}
