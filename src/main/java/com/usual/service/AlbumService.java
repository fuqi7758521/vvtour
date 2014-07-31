package com.usual.service;

import com.common.utils.PublicResult;
import com.usual.entity.AlbumInfo;

public interface AlbumService {


	/**
	 * @param AlbumInfo
	 * @return
	 */
	public PublicResult<String> addAlbum(AlbumInfo info);
	
	/**
	 * 
	 * @param ablumId
	 * @return
	 */
	public PublicResult<AlbumInfo> queryAlbumInfoByAlbumId(String album_id);
	
	
	/**
	 * @param ablumName
	 * @return
	 */
	public PublicResult<AlbumInfo> queryAlbumInfoByAlbumName(String album_name);
	
	/**
	 * @param album_id
	 * @param uploadCount
	 * @return
	 */
	public PublicResult<Boolean> updateAlbumPicCount(String album_id,int type);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<AlbumInfo> queryAlbumInfoList(int start, int max,String album_type);
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryAlbumCount(String album_type);
	
	/**
	 * @param ablumName
	 * @return
	 */
	public PublicResult<Boolean> deltelAlbum(String albumId);
	
}
