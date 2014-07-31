package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.dao.ProductInfoDao;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.manager.ProductInfoManager;
import com.vvtour.shop.manager.impl.CategoryInfoManagerImpl.CategoryInfoField;
import com.vvtour.shop.manager.impl.TourPathManagerImpl.TourPathField;

public class ProductInfoManagerImpl implements ProductInfoManager {

	@Autowired
	private ProductInfoDao productInfoDao;
	
	class ProductInfoField{
		final static String PROID = "pro_id";
		
		final static String CATYPE = "ca_type";
		
		final static String PARENTID = "parent_id";
		
		final static String PARENTNAME = "parent_name";
		
		final static String CAID = "ca_id";
		
		final static String CANAME = "ca_name";
		
		final static String DISCOUNTTAG = "discount_tag";
		
		final static String EDITTIME = "edit_time";
		
		final static String TOURPATH = "tour_path";
		
		final static String TOURDAYS = "tour_days";
		
		final static String TOURTITLE = "tour_title";
		
		final static String TOURIMAGES = "tour_images";
		
		final static String STARTCITY = "start_city";
		
		final static String ENDCITY = "end_city";
		
		final static String STARTDATES = "start_dates";
		
		final static String SEARCHTAG = "search_tag";
		
		final static String TOURVISA = "tour_visa";
		
		final static String TOURTIP = "tour_tip";
		
		final static String VEHICLE = "vehicle";
		
		final static String TOURFEE = "tour_fee";
		
		final static String TOURFEATURE = "tour_feature";
		
		final static String TOURCON = "tour_con";
		
		final static String TOPICTAG = "topic_tag";
		
		final static String FEATURETAG = "feature_tag";
		
		final static String MEMBERPRICE = "member_price";
		
		final static String MARKETPRICE = "market_price";
		
		final static String PAGEDESCRIPT = "page_descript";
		
		
		final static String PAGEKEYWORD = "page_keyword";
		
		final static String PAGETITLE = "page_title";
		
		final static String PAYFORM = "pay_form";
		
		final static String PUBNICK = "pub_nick";
		
		final static String PUBUSER = "pub_user";
		
		final static String SALETITLE = "sale_title";
		
		final static String STATUS = "status";
		
		
	}
	
	@Override
	public boolean addProductInfo(ProductInfo info) {
		productInfoDao.addProductInfo(info);
		return true;
	}

	@Override
	public boolean addProductInfoBatch(List<ProductInfo> infoList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProductInfo(ProductInfo info) {
		Query query = Query.query(Criteria.where(ProductInfoField.PROID).is(info.getPro_id()));
		
		Update update = new Update();
		update.set(ProductInfoField.PARENTID, info.getParent_id());
		update.set(ProductInfoField.PARENTNAME, info.getParent_name());
		update.set(ProductInfoField.CATYPE, info.getCa_type());
		update.set(ProductInfoField.CAID, info.getCa_id());
		update.set(ProductInfoField.CANAME, info.getCa_name());
		update.set(ProductInfoField.DISCOUNTTAG, info.getDiscount_tag());
		update.set(ProductInfoField.EDITTIME, info.getEdit_time());
		update.set(ProductInfoField.ENDCITY, info.getEnd_city());
		update.set(ProductInfoField.FEATURETAG, info.getFeature_tag());
		update.set(ProductInfoField.MARKETPRICE, info.getMarket_price());
		update.set(ProductInfoField.MEMBERPRICE, info.getMember_price());
		update.set(ProductInfoField.PAGEDESCRIPT, info.getPage_descript());
		update.set(ProductInfoField.PAGEKEYWORD, info.getPage_keyword());
		update.set(ProductInfoField.PAGETITLE, info.getPage_title());
		update.set(ProductInfoField.PAYFORM, info.getPay_form());
		update.set(ProductInfoField.PUBNICK, info.getPub_nick());
		update.set(ProductInfoField.PUBUSER, info.getPub_user());
		update.set(ProductInfoField.SALETITLE, info.getSale_title());
		update.set(ProductInfoField.SEARCHTAG, info.getSearch_tag());
		update.set(ProductInfoField.STARTCITY, info.getStart_city());
		update.set(ProductInfoField.STARTDATES, info.getStart_dates());
		update.set(ProductInfoField.TOPICTAG, info.getTopic_tag());
		update.set(ProductInfoField.TOURCON, info.getTour_con());
		
		update.set(ProductInfoField.TOURDAYS, info.getTour_days());
		update.set(ProductInfoField.TOURFEATURE, info.getTour_feature());
		update.set(ProductInfoField.TOURFEE, info.getTour_fee());
		update.set(ProductInfoField.TOURIMAGES, info.getTour_images());
		
		update.set(ProductInfoField.TOURTIP, info.getTour_tip());
		update.set(ProductInfoField.TOURTITLE, info.getTour_title());
		update.set(ProductInfoField.TOURVISA, info.getTour_visa());
		update.set(ProductInfoField.VEHICLE, info.getVehicle());
		return productInfoDao.editProductInfo(query, update);
	}

	@Override
	public ProductInfo queryInfo(String pro_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(pro_id)){
			query = query.addCriteria(Criteria.where(ProductInfoField.PROID).is(pro_id));
		}
		ProductInfo info = productInfoDao.queryProductInfo(query);
		
		return info;
	}


	@Override
	public boolean deltelProductInfo(String pro_id) {
		Query query = Query.query(Criteria.where(ProductInfoField.PROID).is(pro_id));
		return productInfoDao.deleteProductInfo(query);
	}

	@Override
	public List<ProductInfo> queryProductList(int start, int max,
			String parent_id, String ca_id,String pro_id, String search) {
		Query query = new Query();
		if(StringUtils.isNotBlank(pro_id)){
			query.addCriteria(Criteria.where(ProductInfoField.PROID).is(pro_id));
		}
		if(StringUtils.isNotBlank(parent_id)){
			query.addCriteria(Criteria.where(ProductInfoField.PARENTID).is(parent_id));
		}
		if(StringUtils.isNotBlank(ca_id)){
			query.addCriteria(Criteria.where(ProductInfoField.CAID).is(ca_id));
		}
		if(StringUtils.isNotBlank(search)){
			query.addCriteria(Criteria.where(ProductInfoField.SEARCHTAG).all(search));
		}
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return productInfoDao.queryProductInfoList(query);
	}

	@Override
	public long queryProductCount(String parent_id, String ca_id,String pro_id, String search) {
		Query query = new Query();
		if(StringUtils.isNotBlank(pro_id)){
			query.addCriteria(Criteria.where(ProductInfoField.PROID).is(pro_id));
		}
		if(StringUtils.isNotBlank(parent_id)){
			query.addCriteria(Criteria.where(ProductInfoField.PARENTID).is(parent_id));
		}
		if(StringUtils.isNotBlank(ca_id)){
			query.addCriteria(Criteria.where(ProductInfoField.CAID).is(ca_id));
		}
		if(StringUtils.isNotBlank(search)){
			query.addCriteria(Criteria.where(ProductInfoField.SEARCHTAG).all(search));
		}
		return productInfoDao.queryProductInfoCount(query);
	}

	@Override
	public boolean updateProductStatus(String pro_id, int status) {
		Query query = Query.query(Criteria.where(ProductInfoField.PROID).is(pro_id));
		
		Update update = new Update();
		update.set(ProductInfoField.STATUS, status);
		return productInfoDao.editProductInfo(query, update);
	}

}
