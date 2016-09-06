package com.lovo.servers.inter;

import java.util.List;

import com.lovo.entity.Menu;

public interface MenuInt {
	/**
	 * 通过r_id查询二级菜单 、将查出来的子菜单放入父菜单的集合内并返回
	 * @param r_id/角色id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id);
	/**
	 * 查询所有菜单
	 * @param m
	 * @return
	 */
	public List<Menu> showMenu(Menu m);
	/**
	 * 分页显示所有菜单
	 * @param m
	 * @return
	 */
	public List<Menu> pageShowMenu(Menu m,int pageNumber,int pageSize);
	/**
	 * 查询一级菜单
	 * @return
	 */
	public List<Menu> queryMenuParent();
	/**
	 * 查询二级菜单
	 * @return
	 */
	public List<Menu> querysubmenu();
	/**
	 * 增加菜单
	 * @param m
	 */
	public void addMenu(Menu m);
	/**
	 * 删除菜单
	 * @param id
	 */
	public void deleteMenu(int id);
}
