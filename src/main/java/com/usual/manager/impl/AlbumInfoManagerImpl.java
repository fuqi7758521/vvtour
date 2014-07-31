package com.usual.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.common.utils.Constants;
import com.usual.dao.AlbumInfoDao;
import com.usual.entity.AdminInfo;
import com.usual.entity.AlbumInfo;
import com.usual.manager.AlbumInfoManager;
import com.usual.manager.impl.AdminInfoManagerImpl.AdminInfoField;
import com.usual.manager.impl.SystemIdManagerImpl.SystemIdFiled;

public class AlbumInfoManagerImpl implements AlbumInfoManager {
	
	@Autowired
	private AlbumInfoDao albumInfoDao;

	class AlbumInfoField{
		final static String ALBUMID = "album_id";
		
		final static String ALBUMNAME = "album_name";
		
		final static String ALBUMTYPE = "album_type";
		
		final static String ALBUMCOMMENT = "album_comment";
		
		final static String PICTURECOUNT = "picture_count";
	}

	@Override
	public boolean addAlbumInfo(AlbumInfo info) {
		albumInfoDao.addAlbum(info);
		return true;
	}

	@Override
	public AlbumInfo queryInfoByAlbumName(String albumName) {
		Query query = Query.query(Criteria.where(AlbumInfoField.ALBUMNAME).is(albumName));
		AlbumInfo ablumInfo = albumInfoDao.queryAlbum(query);
		return ablumInfo;
	}

	@Override
	public AlbumInfo queryAlbumNameByAlbumId(String album_id) {
		Query query = Query.query(Criteria.where(AlbumInfoField.ALBUMID).is(album_id));
		AlbumInfo ablumInfo = albumInfoDao.queryAlbum(query);
		
		return ablumInfo;
	}

	@Override
	public List<AlbumInfo> queryAlbumInfoList(int start, int max,String album_type) {
		Query query = new Query();
		if(StringUtils.isNotBlank(album_type)){
			query.addCriteria(Criteria.where(AlbumInfoField.ALBUMTYPE).is(album_type));
		}
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return albumInfoDao.queryAlbumList(query);
	}

	@Override
	public long queryAlbumInfoCount(String album_type) {
		Query query = new Query();
		if(StringUtils.isNotBlank(album_type)){
			query.addCriteria(Criteria.where(AlbumInfoField.ALBUMTYPE).is(album_type));
		}
		
		return albumInfoDao.queryAlbumInfoCount(query);
	}

	@Override
	public boolean deltelAlbum(String albumId) {
		Query query = Query.query(Criteria.where(AlbumInfoField.ALBUMID).is(albumId));
		return albumInfoDao.deleteAlbumInfo(query);
	}

	@Override
	public boolean updateAlbumPicCount(String album_id,int type) {
		Query query = Query.query(Criteria.where(AlbumInfoField.ALBUMID).is(album_id));
		Update update = new Update();
		if(type == Constants.ACTION_ALBUMPIC_UPLOAD){
			update.inc(AlbumInfoField.PICTURECOUNT, 1);
		}else{
			update.inc(AlbumInfoField.PICTURECOUNT, -1);
		}
		
		AlbumInfo info = albumInfoDao.updateAlbumPicCount(query, update);
		if(info == null){
			return false;
		}
		return true;
	}
}
