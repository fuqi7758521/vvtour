package com.usual.service;

import com.common.utils.PublicResult;
import com.usual.entity.AlbumPic;

public interface AlbumPicService {


	/**
	 * @param AlbumPic
	 * @return
	 */
	public PublicResult<String> addAlbumPic(AlbumPic info);
	
	/**
	 * 
	 * @param pic_id
	 * @return
	 */
	public PublicResult<AlbumPic> queryAlbumPicByPicID(String pic_id);
	
	
	/**
	 * @param ablumName
	 * @return
	 */
	public PublicResult<AlbumPic> queryAlbumPicByPicName(String pic_name);
	
	/**
	 * @param album_id
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<AlbumPic> queryAlbumPicList(String album_id,int start, int max);
	
	/**
	 * @param album_id
	 * @return
	 */
	public PublicResult<Long> queryAlbumPicCount(String album_id);
	
	/**
	 * @param pic_id
	 * @return
	 */
	public PublicResult<Boolean> deletelAlbumPic(String pic_id);
	
}
