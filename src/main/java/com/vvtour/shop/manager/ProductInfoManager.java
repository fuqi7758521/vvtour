package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.entity.ProductInfo;

public interface ProductInfoManager {

	/**
	 * @param ProductInfo info
	 * @return
	 */
	public boolean addProductInfo(ProductInfo info);
	
	/**
	 * @param List<ProductInfo> infoList
	 * @return
	 */
	public boolean addProductInfoBatch(List<ProductInfo> infoList);
	
	/**
	 * @param String path_id,String path_name,String visit_id,String visit_name
	 */
	public boolean editProductInfo(ProductInfo info);
	
	/**
	 * @param String path_id,String path_name,String visit_id,String visit_name
	 */
	public boolean updateProductStatus(String pro_id,int status);
	
	/**
	 * @param visit_id,path_id,path_name
	 * @return
	 */
	public ProductInfo queryInfo(String pro_id);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<ProductInfo> queryProductList(int start, int max,String parent_id,String ca_id,String pro_id,String search);
	
	/**
	 * @return
	 */
	public long queryProductCount(String parent_id,String ca_id,String pro_id,String search);
	
	/**
	 * @param path_id
	 * @return
	 */
	public boolean deltelProductInfo(String pro_id);
}
