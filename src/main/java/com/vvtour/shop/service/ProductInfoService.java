package com.vvtour.shop.service;

import com.common.utils.PublicResult;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.TourPath;

public interface ProductInfoService {

	/**
	 * @param ProductInfo
	 * @return
	 */
	public PublicResult<String> pubProductInfo(ProductInfo info);
	
	/**
	 * @param ProductInfo
	 * @return
	 */
	public PublicResult<Boolean> editProductInfo(ProductInfo info);
	
	/**
	 * @param ProductInfo
	 * @return
	 */
	public PublicResult<Boolean> updateProductStatus(String pro_id,int status);
	
	/**
	 * @param pro_id
	 * @return
	 */
	public PublicResult<ProductInfo> queryProductInfo(String pro_id);
	
	
	/**
	 * @param parent_id
	 * @param ca_id
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<ProductInfo> queryProductList(int start, int max,String parent_id,String ca_id,String pro_id,String search);
	
	/**
	 * @param parent_id
	 * @param ca_id
	 * @return
	 */
	public PublicResult<Long> queryProductCount(String parent_id, String ca_id,String pro_id,String search);

	/**
	 * @param pro_id
	 * @return
	 */
	public PublicResult<Boolean> delProduct(String pro_id);
}
