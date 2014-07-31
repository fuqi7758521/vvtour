package com.usual.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.AlbumPic;

public interface AlbumPicDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public AlbumPic queryAlbumPic(Query query);
	
	/**
	 * @param AlbumPic
	 */
	public void addAlbumPic(AlbumPic info);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public AlbumPic updateAlbumPic(Query query,Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateBatchAlbumPic(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<AlbumPic> queryAlbumPicList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryAlbumPicCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteAlbumPic(Query query);

}
