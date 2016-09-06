package com.lovo.servers.inter;

import java.util.List;

import com.lovo.entity.Menu;
import com.lovo.entity.Role;

public interface RoleInt {
	/**
	 * 查询出所有角色信息
	 * @param role
	 * @return
	 */
	public List<Role> showRole(Role role);
	/**
	 * 分页显示所有角色
	 * @param role
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Role> pageShowRole(Role role,int pageNumber,int pageSize);
	/**
	 * 通过角色ID查询角色拥有的菜单
	 * @param r_id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id);
}
