package com.usual.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.usual.entity.AlbumInfo;
import com.usual.manager.AlbumInfoManager;
import com.usual.manager.SystemIdManager;
import com.usual.service.AlbumService;
import com.usual.service.BaseService;
import com.common.utils.CodeEnum;
import com.usual.utils.IdTypeEnum;
import com.common.utils.PublicResult;

public class AlbumInfoServiceImpl extends BaseService implements AlbumService {
	
	private final static Logger logger = Logger
			.getLogger(AlbumInfoServiceImpl.class);
	
	@Autowired
	private AlbumInfoManager albumManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> addAlbum(AlbumInfo info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String albumName = info.getAlbum_name();
			AlbumInfo isExist = albumManager.queryInfoByAlbumName(albumName);
			if (isExist!=null) {
				logger.error("Album Name is exist " + isExist.toString());
				return failPublicResult(result,
						CodeEnum.VALIDATE_DATA_EXIST.getCode());
			}
			info.setPicture_count(0);
			String albumId = systemIdManager.getSystemId(IdTypeEnum.ADMIN_ALBUM_ID);
			info.setAlbum_id(albumId);
			boolean regResult = albumManager.addAlbumInfo(info);
			
			if(regResult){
				result.setModel(albumId);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<AlbumInfo> queryAlbumInfoList(int start, int max,String album_type) {
		PublicResult<AlbumInfo> result = new PublicResult<AlbumInfo>(false);

		try {

			long count = albumManager.queryAlbumInfoCount(album_type);
			result.setCount(count);
			if (count > 0) {
				List<AlbumInfo> albums = albumManager.queryAlbumInfoList(start,
						max,album_type);
				result.setModelList(albums);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Boolean> updateAlbumPicCount(String album_id,int type) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = albumManager.updateAlbumPicCount(album_id,type);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Boolean> deltelAlbum(String albumId) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = albumManager.deltelAlbum(albumId);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AlbumInfo> queryAlbumInfoByAlbumId(String album_id) {
		PublicResult<AlbumInfo> result = new PublicResult<AlbumInfo>(false);
		if (StringUtils.isBlank(album_id)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			AlbumInfo info = albumManager.queryAlbumNameByAlbumId(album_id);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AlbumInfo> queryAlbumInfoByAlbumName(String album_name) {
		PublicResult<AlbumInfo> result = new PublicResult<AlbumInfo>(false);
		if (StringUtils.isBlank(album_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			AlbumInfo info = albumManager.queryInfoByAlbumName(album_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryAlbumCount(String album_type) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = albumManager.queryAlbumInfoCount(album_type);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}



}
