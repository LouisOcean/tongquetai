package com.lovo.servers.impl;


import java.util.List;



import com.lovo.dao.impl.RoleDaoImp;
import com.lovo.dao.inter.RoleDao;
import com.lovo.entity.Menu;
import com.lovo.entity.Role;
import com.lovo.servers.inter.RoleInt;

public class RoleImp implements RoleInt{
	RoleDao roleDao = new RoleDaoImp();
	/**
	 * 查询出所有角色信息
	 * @param role
	 * @return
	 */
	public List<Role> showRole(Role role){
		return roleDao.showRole(role);
	}
	/**
	 * 分页显示所有角色
	 * @param role
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Role> pageShowRole(Role role,int pageNumber,int pageSize){
		
		return roleDao.pageShowRole(role, pageNumber, pageSize);
	}
	/**
	 * 通过角色ID查询角色拥有的菜单
	 * @param r_id
	 * @return
	 */
	public List<Menu> queryMenu(int r_id){
		return roleDao.queryMenu(r_id);
	}
}
