package com.usual.manager;

import java.util.List;

import com.usual.entity.AlbumPic;

public interface AlbumPicManager {
	
	/**
	 * @param AlbumPic
	 * @return
	 */
	public boolean addAlbumPic(AlbumPic info);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<AlbumPic> queryAlbumPicList(String album_id,int start, int max);
	
	/**
	 * @return
	 */
	public AlbumPic queryAlbumPict(String pic_id);
	
	
	/**
	 * @return
	 */
	public long queryAlbumPicCount(String album_id);
	
	/**
	 * @param albumId
	 * @return
	 */
	public boolean deletelAlbum(String pic_id);
	
}
