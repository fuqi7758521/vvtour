package com.usual.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.AlbumInfo;

public interface AlbumInfoDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public AlbumInfo queryAlbum(Query query);
	
	/**
	 * @param AlbumInfo
	 */
	public void addAlbum(AlbumInfo info);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public AlbumInfo updateAlbumPicCount(Query query,Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateBatchAlbum(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<AlbumInfo> queryAlbumList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryAlbumInfoCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteAlbumInfo(Query query);

}
