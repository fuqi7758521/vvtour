package com.vvtour.shop.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.usual.entity.AlbumInfo;
import com.vvtour.shop.dao.CategoryInfoDao;
import com.vvtour.shop.entity.CategoryInfo;

public class CategoryInfoDaoImpl extends BaseDao implements CategoryInfoDao {

	@Override
	public CategoryInfo queryCategoryInfo(Query query) {
		return (CategoryInfo)queryOne(query,new CategoryInfo());
	}

	@Override
	public void addCategoryInfo(CategoryInfo info) {
		saveOne(info);
	}

	@Override
	public void addCategoryInfoBatch(List<CategoryInfo> infoList) {
		saveBatch(infoList);
	}

	@Override
	public List<CategoryInfo> queryCategoryInfoList(Query query) {
		return (List<CategoryInfo>) queryList(query, new CategoryInfo());
	}

	@Override
	public long queryCategoryInfoCount(Query query) {
		return getCount(query, new CategoryInfo());
	}

	@Override
	public boolean deleteCategoryInfo(Query query) {
		delOne(query,new CategoryInfo());
		return true;
	}

	@Override
	public boolean updateInfo(Query query, Update update) {
		CategoryInfo info = new CategoryInfo();
		info = (CategoryInfo)findAndModify(query, update, new CategoryInfo());
		if(info!=null)return true;
		else return false;
	}

}
