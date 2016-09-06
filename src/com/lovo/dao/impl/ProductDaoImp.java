package com.lovo.dao.impl;

import java.util.List;

import util.JDBCUtil;

import com.lovo.dao.inter.ProductDao;
import com.lovo.entity.Product;

public class ProductDaoImp implements ProductDao{
	/**
	 * 查询有所有有效产品
	 * @param p
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Product> showProduct(Product p){
		String sql = "select * from product where p_state='YES'";
		List<Product> list = (List<Product>)JDBCUtil.queryEntities(Product.class, sql);
		return list;
	}
	/**
	 * 分页查询所有产品  
	 * @param p
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Product> showAllProduct(Product p,int pageNumber,int pageSize){
		String sql = "select * from product where p_state='YES' limit "+(pageNumber-1)*pageSize+","+pageSize;
		List<Product> listp = (List<Product>)JDBCUtil.queryEntities(Product.class, sql);
		return listp;
	}
	/**
	 * 添加产品
	 * @param p
	 */
	public void addProduct(Product p){
		String sql = "INSERT INTO product (p_name,recommendDoctor,p_describe,createTime,p_state) VALUES (?,?,?,?,?)";
		JDBCUtil.DMLOperate(sql, p.getP_name(),p.getRecommendDoctor(),p.getP_describe(),p.getCreateTime(),p.getP_state());
	}
	/**
	 * 删除产品(假删除)
	 * @param p_id
	 */
	public void delectProduct(int p_id){
		String sql = "UPDATE product SET p_state = 'NO' WHERE p_id = ?";
		JDBCUtil.DMLOperate(sql, p_id);
	}
	/**
	 * 根据传入的ID查询用户信息、、、表单回填
	 * @param p_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Product backfillProduct(int p_id){
		Product product = null;
		String sql = "select * from product where p_id = ?";
		List<Product> list = (List<Product>)JDBCUtil.queryEntities(Product.class, sql, p_id);
		product = list.get(0);
		return product;
	}
	/**
	 * 修改产品
	 */
	public void modifyProduct(Product p){
		String sql = "UPDATE product SET p_name=?,recommendDoctor=?,p_describe=?,createTime=?,p_state=? WHERE p_id=?";
		JDBCUtil.DMLOperate(sql, p.getP_name(),p.getRecommendDoctor(),p.getP_describe(),p.getCreateTime(),p.getP_state(),p.getP_id());
	}
}
