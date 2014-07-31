package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.dao.CategoryInfoDao;
import com.vvtour.shop.entity.CategoryInfo;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.manager.CategoryInfoManager;
import com.vvtour.shop.manager.impl.TourPathManagerImpl.TourPathField;
import com.vvtour.shop.manager.impl.VisitParentManagerImpl.VisitParentField;

public class CategoryInfoManagerImpl implements CategoryInfoManager {

	@Autowired
	private CategoryInfoDao categoryDao;
	
	class CategoryInfoField{
		final static String CAID = "ca_id";
		
		final static String CANAME = "ca_name";
		
		final static String CATYPE = "ca_type";
		
		final static String PARENTID = "parent_id";
		
		final static String ISHAS = "ishas";
		
		final static String PRONUM = "pro_num";
		
	}
	
	@Override
	public boolean addCategoryInfo(CategoryInfo info) {
		categoryDao.addCategoryInfo(info);
		return true;
	}

	@Override
	public boolean addCategoryInfoBatch(List<CategoryInfo> infoList) {
		categoryDao.addCategoryInfoBatch(infoList);
		return true;
	}

	@Override
	public boolean editCategoryInfo(CategoryInfo info) {
		
		Query query = Query.query(Criteria.where(CategoryInfoField.CAID).is(info.getCa_id()));
		
		Update update = new Update();
		if(StringUtils.isNotBlank(info.getParent_id())){
			update.set(CategoryInfoField.PARENTID, info.getParent_id());
		}
		if(StringUtils.isNotBlank(info.getCa_name())){
			update.set(CategoryInfoField.CANAME, info.getCa_name());
		}
		return categoryDao.updateInfo(query, update);
	}

	@Override
	public boolean editCategoryName(String ca_id, String ca_name) {
		Query query = Query.query(Criteria.where(CategoryInfoField.CAID).is(ca_id));
		Update update = new Update();
		update.set(CategoryInfoField.CANAME, ca_name);
		return categoryDao.updateInfo(query, update);
	}

	@Override
	public CategoryInfo queryInfo(String ca_id, String ca_name,String parent_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(ca_id)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.CAID).is(ca_id));
		}
		
		if(StringUtils.isNotBlank(ca_name)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.CANAME).is(ca_name));
		}
		if(StringUtils.isNotBlank(parent_id)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.PARENTID).is(parent_id));
		}
		
		CategoryInfo info = categoryDao.queryCategoryInfo(query);
		
		return info;
	}

	@Override
	public List<CategoryInfo> queryCategoryInfoList(String ca_type,String parent_id,int start, int max) {
		Query query = new Query();
		if(StringUtils.isNotBlank(parent_id)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.PARENTID).is(parent_id));
		}
		if(StringUtils.isNotBlank(ca_type)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.CATYPE).is(ca_type));
		}
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return categoryDao.queryCategoryInfoList(query);
	}

	@Override
	public long queryCategoryInfoCount(String ca_type,String parent_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(parent_id)){
			query = Query.query(Criteria.where(CategoryInfoField.PARENTID).is(parent_id));
		}
		if(StringUtils.isNotBlank(ca_type)){
			query = query.addCriteria(Criteria.where(CategoryInfoField.CATYPE).is(ca_type));
		}
		return categoryDao.queryCategoryInfoCount(query);
	}

	@Override
	public boolean deleteCategory(String ca_id) {
		Query query = Query.query(Criteria.where(CategoryInfoField.CAID).is(ca_id));
		return categoryDao.deleteCategoryInfo(query);
	}

}
