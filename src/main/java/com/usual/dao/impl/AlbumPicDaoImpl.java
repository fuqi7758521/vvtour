package com.usual.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.AlbumPicDao;
import com.usual.dao.BaseDao;
import com.usual.entity.AlbumPic;

public class AlbumPicDaoImpl extends BaseDao implements AlbumPicDao {

	@Override
	public AlbumPic queryAlbumPic(Query query) {
		return (AlbumPic)queryOne(query,new AlbumPic());
	}

	@Override
	public void addAlbumPic(AlbumPic info) {
		saveOne(info);
	}

	@Override
	public AlbumPic updateAlbumPic(Query query, Update update) {
		return (AlbumPic) findAndModify(query, update, new AlbumPic());
	}

	@Override
	public boolean updateBatchAlbumPic(Query query, Update update) {
		return updateBatch(query, update, new AlbumPic());
	}

	@Override
	public List<AlbumPic> queryAlbumPicList(Query query) {
		return (List<AlbumPic>) queryList(query, new AlbumPic());
	}

	@Override
	public long queryAlbumPicCount(Query query) {
		return getCount(query, new AlbumPic());
	}

	@Override
	public boolean deleteAlbumPic(Query query) {
		delOne(query,new AlbumPic());
		return true;
	}

}
