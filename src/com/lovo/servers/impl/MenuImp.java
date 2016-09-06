package com.lovo.servers.impl;


import java.util.List;

import com.lovo.dao.impl.MenuDaoImp;
import com.lovo.dao.inter.MenuDao;
import com.lovo.entity.Menu;
import com.lovo.servers.inter.MenuInt;

public class MenuImp implements MenuInt{
	MenuDao menuDao = new MenuDaoImp();
	/**
	 * 通过r_id查询二级菜单 、将查出来的子菜单放入父菜单的集合内并返回
	 * @param r_id/角色id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id) {
		
		return menuDao.queryMenu(r_id);
	}
	/**
	 * 查询所有菜单
	 * @param m
	 * @return
	 */
	public List<Menu> showMenu(Menu m) {
		return menuDao.showMenu(m);
	}
	/**
	 * 分页显示所有菜单
	 * @param m
	 * @return
	 */
	public List<Menu> pageShowMenu(Menu m,int pageNumber,int pageSize){
		return menuDao.pageShowMenu(m, pageNumber, pageSize);
	}
	/**
	 * 查询一级菜单
	 * @return
	 */
	public List<Menu> queryMenuParent(){
		return menuDao.queryMenuParent();
	}
	/**
	 * 查询二级菜单
	 * @return
	 */
	public List<Menu> querysubmenu(){
		
		return menuDao.querysubmenu();
	}
	/**
	 * 增加菜单
	 */
	public void addMenu(Menu m) {
		 menuDao.addMenu(m);
	}
	/**
	 * 删除菜单
	 * @param id
	 */
	public void deleteMenu(int id){
		menuDao.deleteMenu(id);
	}

}
