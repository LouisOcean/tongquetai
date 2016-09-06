package com.lovo.servers.inter;

import java.util.List;

import com.lovo.entity.Product;

public interface ProductInt {
	/**
	 * 查询有所有有效产品
	 * @param p
	 * @return
	 */
	public List<Product> showProduct(Product p);
	/**
	 * 分页查询所有产品  
	 * @param p
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Product> showAllProduct(Product p,int pageNumber,int pageSize);
	/**
	 * 添加产品
	 * @param p
	 */
	public void addProduct(Product p);
	/**
	 * 删除产品(假删除)
	 * @param p_id
	 */
	public void delectProduct(int p_id);
	/**
	 * 根据传入的ID查询用户信息、、、表单回填
	 * @param p_id
	 * @return
	 */
	public Product backfillProduct(int p_id);
	/**
	 * 修改产品
	 * @param p
	 */
	public void modifyProduct(Product p);
}
