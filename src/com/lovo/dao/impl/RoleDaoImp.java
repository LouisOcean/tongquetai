package com.lovo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JBUtil;
import util.JDBCUtil;

import com.lovo.dao.inter.RoleDao;
import com.lovo.entity.Menu;
import com.lovo.entity.Role;

public class RoleDaoImp implements RoleDao{
	/**
	 * 查询出所有角色信息
	 * @param role
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Role> showRole(Role role){
		String sql = "select * from role ";
		List<Role> list = (List<Role>)JDBCUtil.queryEntities(Role.class, sql);
		return list;
	}
	/**
	 * 分页显示所有角色
	 * @param role
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Role> pageShowRole(Role role,int pageNumber,int pageSize){
		String sql = "select * from role limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Role> list = (List<Role>)JDBCUtil.queryEntities(Role.class, sql);
		return list;
	}
	/**
	 * 通过角色ID查询角色拥有的菜单
	 * @param r_id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id){
		List<Menu> parentList = new ArrayList<Menu>();//父菜单集合
		List<Menu> submenuList = new ArrayList<Menu>();
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Menu menu = null;
		try {
			//查询一级菜单
			String sql = "SELECT * FROM menu m LEFT JOIN (SELECT * FROM role_menu WHERE r_id=?) r ON m.id=r.m_id WHERE parent_id=-1";
			ps = con.prepareStatement(sql);
			ps.setInt(1, r_id);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String m_name = rs.getString(2);
				String url = rs.getString(3);
				int parten_id = rs.getInt(4);
				menu = new Menu(id,m_name,url,parten_id);
				//添加到父菜单集合内
				parentList.add(menu);
			}
			//查询二级菜单
			String subsql = "SELECT * FROM menu m LEFT JOIN (SELECT * FROM role_menu WHERE r_id=?) r ON m.id=r.m_id WHERE parent_id!=-1";
			ps = con.prepareStatement(subsql);
			ps.setInt(1, r_id);
			rs = ps.executeQuery();
			while(rs.next()){
				int mid = rs.getInt(1);
				String m_name = rs.getString(2);
				String url = rs.getString(3);
				int parten_id = rs.getInt(4);
				menu = new Menu(mid,m_name,url,parten_id);
				submenuList.add(menu);
			}
			for(Menu plist:parentList){
				for(Menu slist:submenuList){
					if(slist.getParten_id() == plist.getId()){
						plist.getSubmenu().add(slist);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JBUtil.close(rs, ps, con);
		}
		return parentList;
	}
}
