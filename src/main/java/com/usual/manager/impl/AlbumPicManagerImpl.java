package com.usual.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.usual.dao.AlbumPicDao;
import com.usual.entity.AlbumPic;
import com.usual.manager.AlbumPicManager;

public class AlbumPicManagerImpl implements AlbumPicManager {
	
	@Autowired
	private AlbumPicDao albumPicDao;

	class AlbumPicField{
		final static String PICID = "pic_id";
		
		final static String PICNAME = "pic_name";
		
		final static String PICURL = "pic_url";
		
		final static String PICCOMMENT = "pic_comment";
		
		final static String ALBUMID = "album_id";
	}

	@Override
	public boolean addAlbumPic(AlbumPic info) {
		albumPicDao.addAlbumPic(info);
		return true;
	}

	@Override
	public List<AlbumPic> queryAlbumPicList(String albumId, int start, int max) {
		Query query = new Query();
		if(StringUtils.isNotBlank(albumId)){
			query = Query.query(Criteria.where(AlbumPicField.ALBUMID).is(albumId));
		}
		query.skip(start);
		query.limit(max);
		query.with(new Sort(Sort.Direction.DESC,AlbumPicField.PICID));
		return albumPicDao.queryAlbumPicList(query);
	}

	@Override
	public long queryAlbumPicCount(String album_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(album_id)){
			query = Query.query(Criteria.where(AlbumPicField.ALBUMID).is(album_id));
		}
		
		return albumPicDao.queryAlbumPicCount(query);
	}

	@Override
	public boolean deletelAlbum(String pic_id) {
		Query query = Query.query(Criteria.where(AlbumPicField.PICID).is(pic_id));
		return albumPicDao.deleteAlbumPic(query);
	}

	@Override
	public AlbumPic queryAlbumPict(String pic_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(pic_id)){
			query = Query.query(Criteria.where(AlbumPicField.PICID).is(pic_id));
		}
		
		return albumPicDao.queryAlbumPic(query);
	}
	
	

}
