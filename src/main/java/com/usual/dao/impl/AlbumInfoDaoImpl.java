package com.usual.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.AlbumInfoDao;
import com.usual.dao.BaseDao;
import com.usual.entity.AlbumInfo;

public class AlbumInfoDaoImpl extends BaseDao implements AlbumInfoDao {

	@Override
	public AlbumInfo queryAlbum(Query query) {
		return (AlbumInfo)queryOne(query,new AlbumInfo());
	}

	@Override
	public void addAlbum(AlbumInfo info) {
		saveOne(info);
	}

	@Override
	public AlbumInfo updateAlbumPicCount(Query query, Update update) {
		return (AlbumInfo) findAndModify(query, update, new AlbumInfo());
	}

	@Override
	public boolean updateBatchAlbum(Query query, Update update) {
		return updateBatch(query, update, new AlbumInfo());
	}

	@Override
	public List<AlbumInfo> queryAlbumList(Query query) {
		return (List<AlbumInfo>) queryList(query, new AlbumInfo());
	}

	@Override
	public long queryAlbumInfoCount(Query query) {
		return getCount(query, new AlbumInfo());
	}

	@Override
	public boolean deleteAlbumInfo(Query query) {
		delOne(query,new AlbumInfo());
		return true;
	}

}
