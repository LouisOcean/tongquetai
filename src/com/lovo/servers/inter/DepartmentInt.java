package com.lovo.servers.inter;

import java.util.List;

import com.lovo.entity.Department;

public interface DepartmentInt {
	/**
	 * 查出所有有效部门
	 * @param dept
	 * @return
	 */
	public List<Department> showDept(Department dept);
	/**
	 * 分页查出所有有效部门
	 * @param dept
	 * @return
	 */
	public List<Department> showDeptOnPage(Department dept,int pageNumber,int pageSize);
	/**
	 * 添加部门
	 * @param dept
	 */
	public void addDemp(Department dept);
}
