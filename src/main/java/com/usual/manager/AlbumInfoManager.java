package com.usual.manager;

import java.util.List;

import com.common.utils.PublicResult;
import com.usual.entity.AlbumInfo;

public interface AlbumInfoManager {
	
	/**
	 * @param adminInfo
	 * @return
	 */
	public boolean addAlbumInfo(AlbumInfo info);
	
	/**
	 * @param albumName
	 * @return
	 */
	public AlbumInfo queryInfoByAlbumName(String albumName);
	
	/**
	 * @param albumId
	 * @return
	 */
	public AlbumInfo queryAlbumNameByAlbumId(String album_id);
	
	/**
	 * @param album_id
	 * @param uploadCount
	 * @return
	 */
	public boolean updateAlbumPicCount(String album_id,int type);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<AlbumInfo> queryAlbumInfoList(int start, int max,String album_type);
	
	/**
	 * @return
	 */
	public long queryAlbumInfoCount(String album_type);
	
	/**
	 * @param albumId
	 * @return
	 */
	public boolean deltelAlbum(String albumId);
	
}
