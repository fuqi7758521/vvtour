package com.vvtour.shop.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.entity.ProductInfo;

public interface ProductInfoDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public ProductInfo queryProductInfo(Query query);
	
	/**
	 * @param ProductInfo
	 */
	public void addProductInfo(ProductInfo info);
	
	/**
	 * @param ProductInfo
	 */
	public void addProductInfoBatch(List<ProductInfo> infoList);
	
	/**
	 * @param ProductInfo
	 */
	public boolean editProductInfo(Query query, Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<ProductInfo> queryProductInfoList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryProductInfoCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteProductInfo(Query query);

}
