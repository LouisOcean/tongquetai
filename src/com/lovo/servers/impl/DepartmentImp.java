package com.lovo.servers.impl;

import java.util.List;


import com.lovo.dao.impl.DepartmentDaoImp;
import com.lovo.dao.inter.DepartmentDao;
import com.lovo.entity.Department;
import com.lovo.servers.inter.DepartmentInt;

public class DepartmentImp implements DepartmentInt{
	DepartmentDao deptDao = new DepartmentDaoImp();
	/**
	 * 查出所有有效部门
	 * @param dept
	 * @return
	 */
	public List<Department> showDept(Department dept) {
			
		return deptDao.showDept(dept);
	}
	/**
	 * 分页查出所有有效部门
	 * @param dept
	 * @return
	 */
	public List<Department> showDeptOnPage(Department dept, int pageNumber,
			int pageSize) {
		return deptDao.showDeptOnPage(dept, pageNumber, pageSize);
	}
	/**
	 * 添加部门
	 * @param dept
	 */
	public void addDemp(Department dept) {
		deptDao.addDemp(dept);
		
	}

}
