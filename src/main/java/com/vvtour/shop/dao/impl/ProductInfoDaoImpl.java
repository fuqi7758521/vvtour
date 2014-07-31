package com.vvtour.shop.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.vvtour.shop.dao.ProductInfoDao;
import com.vvtour.shop.entity.ProductInfo;

public class ProductInfoDaoImpl extends BaseDao implements ProductInfoDao {

	@Override
	public ProductInfo queryProductInfo(Query query) {
		return (ProductInfo)queryOne(query,new ProductInfo());
	}

	@Override
	public void addProductInfo(ProductInfo info) {
		saveOne(info);
	}

	@Override
	public void addProductInfoBatch(List<ProductInfo> infoList) {
		saveBatch(infoList);
	}

	@Override
	public boolean editProductInfo(Query query, Update update) {
		ProductInfo info = (ProductInfo) findAndModify(query, update, new ProductInfo());
		if(info!=null){
			return true;
		}
		return false;
	}

	@Override
	public List<ProductInfo> queryProductInfoList(Query query) {
		return (List<ProductInfo>) queryList(query, new ProductInfo());
	}

	@Override
	public long queryProductInfoCount(Query query) {
		return getCount(query, new ProductInfo());
	}

	@Override
	public boolean deleteProductInfo(Query query) {
		delOne(query,new ProductInfo());
		return true;
	}

}
