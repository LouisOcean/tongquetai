package com.lovo.servers.impl;

import java.util.List;

import com.lovo.dao.impl.ProductDaoImp;
import com.lovo.dao.inter.ProductDao;
import com.lovo.entity.Product;
import com.lovo.servers.inter.ProductInt;

public class ProductImp implements ProductInt{
	ProductDao productDao = new ProductDaoImp();
	/**
	 * 查询有所有有效产品
	 * @param p
	 * @return
	 */
	public List<Product> showProduct(Product p){
		return productDao.showProduct(p);
	}
	/**
	 * 分页查询所有产品  
	 * @param p
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Product> showAllProduct(Product p,int pageNumber,int pageSize){
		return productDao.showAllProduct(p, pageNumber, pageSize);
	}
	/**
	 * 添加产品
	 * @param p
	 */
	public void addProduct(Product p){
		productDao.addProduct(p);
	}
	/**
	 * 删除产品(假删除)
	 * @param p_id
	 */
	public void delectProduct(int p_id){
		productDao.delectProduct(p_id);
	}
	/**
	 * 根据传入的ID查询用户信息、、、表单回填
	 * @param p_id
	 * @return
	 */
	public Product backfillProduct(int p_id){
		
		return productDao.backfillProduct(p_id);
	}
	/**
	 * 修改产品
	 */
	public void modifyProduct(Product p){
		 productDao.modifyProduct(p);
	}
	
}
