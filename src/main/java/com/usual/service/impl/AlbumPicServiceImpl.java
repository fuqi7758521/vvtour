package com.usual.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.usual.entity.AlbumInfo;
import com.usual.entity.AlbumPic;
import com.usual.manager.AlbumPicManager;
import com.usual.manager.SystemIdManager;
import com.usual.service.AlbumPicService;
import com.usual.service.BaseService;
import com.usual.utils.IdTypeEnum;
import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;

public class AlbumPicServiceImpl extends BaseService implements AlbumPicService {
	
	private final static Logger logger = Logger
			.getLogger(AlbumPicServiceImpl.class);
	
	@Autowired
	private AlbumPicManager albumPicManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> addAlbumPic(AlbumPic info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String picId = systemIdManager.getSystemId(IdTypeEnum.ADMIN_WEB_IMAGES_ID);
			info.setPic_id(picId);
			boolean regResult = albumPicManager.addAlbumPic(info);
			
			if(regResult){
				result.setModel(picId);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<AlbumPic> queryAlbumPicList(String album_id, int start,
			int max) {
		PublicResult<AlbumPic> result = new PublicResult<AlbumPic>(false);

		try {

			long count = albumPicManager.queryAlbumPicCount(album_id);
			result.setCount(count);
			if (count > 0) {
				List<AlbumPic> albumsPic = albumPicManager.queryAlbumPicList(album_id, start, max);
				result.setModelList(albumsPic);
				result.setCount(count);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Boolean> deletelAlbumPic(String pic_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = albumPicManager.deletelAlbum(pic_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Long> queryAlbumPicCount(String album_id) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = albumPicManager.queryAlbumPicCount(album_id);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
		
	}

	@Override
	public PublicResult<AlbumPic> queryAlbumPicByPicID(String pic_id) {
		PublicResult<AlbumPic> result = new PublicResult<AlbumPic>(false);

		try {
			AlbumPic info = albumPicManager.queryAlbumPict(pic_id);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AlbumPic> queryAlbumPicByPicName(String pic_name) {
		// TODO Auto-generated method stub
		return null;
	}





	


}
