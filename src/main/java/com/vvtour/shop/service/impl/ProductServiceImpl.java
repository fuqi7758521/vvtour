package com.vvtour.shop.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.usual.utils.IdTypeEnum;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.manager.ProductInfoManager;
import com.vvtour.shop.service.ProductInfoService;

public class ProductServiceImpl extends BaseService implements
		ProductInfoService {
	
	private final static Logger logger = Logger
			.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductInfoManager productManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> pubProductInfo(ProductInfo info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			
			String pro_id = systemIdManager.getSystemId(IdTypeEnum.PRODUCT_ID);
			info.setPro_id(pro_id);
			boolean regResult = productManager.addProductInfo(info);
			
			if(regResult){
				result.setModel(pro_id);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ProductInfo> queryProductInfo(String pro_id) {
		PublicResult<ProductInfo> result = new PublicResult<ProductInfo>(false);
		if (StringUtils.isBlank(pro_id)&&StringUtils.isBlank(pro_id)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			ProductInfo info = productManager.queryInfo(pro_id);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ProductInfo> queryProductList(int start, int max,
			String parent_id, String ca_id,String pro_id,String search) {
		PublicResult<ProductInfo> result = new PublicResult<ProductInfo>(false);

		try {
			long count = productManager.queryProductCount(parent_id, ca_id,pro_id,search);
			result.setCount(count);
			if (count > 0) {
				List<ProductInfo> products = productManager.queryProductList(start, max,parent_id, ca_id, pro_id,search);
				result.setModelList(products);
				result.setCount(count);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryProductCount(String parent_id, String ca_id,String pro_id,String search) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = productManager.queryProductCount(parent_id, ca_id,pro_id,search);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> delProduct(String pro_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		try {
			Boolean isDel = productManager.deltelProductInfo(pro_id);
			result.setModel(isDel);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> editProductInfo(ProductInfo info) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = productManager.editProductInfo(info);
			result.setModel(editResult);
			if(editResult){
				return succPublicResult(result);
			}
			return failPublicResult(result, CodeEnum.ERROR_OPERATE_FAIL.getCode());
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateProductStatus(String pro_id, int status) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = productManager.updateProductStatus(pro_id, status);
			result.setModel(editResult);
			if(editResult){
				return succPublicResult(result);
			}
			return failPublicResult(result, CodeEnum.ERROR_OPERATE_FAIL.getCode());
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	
}
