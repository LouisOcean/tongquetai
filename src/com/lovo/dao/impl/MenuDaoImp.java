package com.lovo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JBUtil;
import util.JDBCUtil;

import com.lovo.dao.inter.MenuDao;
import com.lovo.entity.Menu;

public class MenuDaoImp implements MenuDao{
	/**
	 * 通过r_id查询二级菜单 、将查出来的子菜单放入父菜单的集合内并返回
	 * @param r_id/角色id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id) {
		List<Menu> parentList = new ArrayList<Menu>();//父菜单了集合
		List<Menu> submenuList = new ArrayList<Menu>();
		Connection con = JBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Menu menu = null;
		try {
			//查询一级菜单
			String sql = "SELECT * FROM menu m JOIN role_menu rm ON m.id = rm.m_id WHERE rm.r_id =? AND m.parent_id=-1";
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
			String subsql = "SELECT * FROM menu m JOIN role_menu rm ON m.id = rm.m_id WHERE rm.r_id =? AND m.parent_id!=-1";
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
	/**
	 * 查询所有菜单
	 * @param m
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> showMenu(Menu m) {
		String sql = "select * from menu";
		List<Menu> list = (List<Menu>)JDBCUtil.queryEntities(Menu.class, sql);
		return list;
	}
	/**
	 * 分页显示所有菜单
	 * @param m
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> pageShowMenu(Menu m,int pageNumber,int pageSize){
		String sql = "select * from menu limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Menu> list = (List<Menu>)JDBCUtil.queryEntities(Menu.class, sql);
		return list;
	}
	/**
	 * 查询一级菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> queryMenuParent(){
		String sql = "select * from menu where parent_id=-1";
		List<Menu> list = (List<Menu>)JDBCUtil.queryEntities(Menu.class, sql);
		return list;
	}
	/**
	 * 查询二级菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> querysubmenu(){
		String sql = "select * from menu where parent_id!=-1";
		List<Menu> list = (List<Menu>)JDBCUtil.queryEntities(Menu.class, sql);
		return list;
	}
	/**
	 * 增加菜单
	 */
	public void addMenu(Menu m) {
		String sql = "INSERT INTO  menu (m_name,url,parent_id) VALUES (?,?,?)";
		JDBCUtil.DMLOperate(sql, m.getM_name(),m.getUrl(),m.getParten_id());
		
	}
	/**
	 * 删除菜单
	 * @param id
	 */
	public void deleteMenu(int id){
		String sql = "DELETE FROM menu WHERE id=?";
		JDBCUtil.DMLOperate(sql, id);
	}
}
