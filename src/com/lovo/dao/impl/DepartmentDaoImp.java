package com.lovo.dao.impl;

import java.util.List;

import util.JDBCUtil;

import com.lovo.dao.inter.DepartmentDao;
import com.lovo.entity.Department;

public class DepartmentDaoImp implements DepartmentDao{
	/**
	 * 查出所有有效部门
	 * @param dept
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Department> showDept(Department dept) {
		String sql = "select * from department where deptState='YES'";
		List<Department> listDept = (List<Department>)JDBCUtil.queryEntities(Department.class, sql);	
		return listDept;
	}
	/**
	 * 分页查出所有有效部门
	 * @param dept
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Department> showDeptOnPage(Department dept, int pageNumber,int pageSize){
		String sql = "select * from department where deptState='YES' limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Department> listDept = (List<Department>)JDBCUtil.queryEntities(Department.class, sql);	
		return listDept;
	}
	/**
	 * 添加部门
	 * @param dept
	 */
	public void addDemp(Department dept) {
		String sql = "INSERT INTO department(d_name,manage_id,d_describe,deptState) VALUES(?,?,?,?)";
		JDBCUtil.DMLOperate(sql,dept.getD_name(),dept.getManage_id(),dept.getD_describe(),dept.getDeptState());
		
	}
	
}
