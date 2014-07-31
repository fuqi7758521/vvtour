package com.usual.entity;

public class AlbumInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2025573367823020564L;
	
	private final static String collectionName = "album_info";
	
	public AlbumInfo() {
		super(collectionName);
	}
	
	private String album_id;
	
	private String album_name;
	
	private String album_comment;
	
	private String album_type;
	
	private Integer picture_count;
	
	
	
	public String getAlbum_type() {
		return album_type;
	}

	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_comment() {
		return album_comment;
	}

	public void setAlbum_comment(String album_comment) {
		this.album_comment = album_comment;
	}
	
	public Integer getPicture_count() {
		return picture_count;
	}

	public void setPicture_count(Integer picture_count) {
		this.picture_count = picture_count;
	}

	@Override
	public String toString() {
		return "AlbumInfo [album_id=" + album_id + ", album_name=" + album_name
				+ ", album_comment=" + album_comment + ", album_type="
				+ album_type + ", picture_count=" + picture_count + "]";
	}

}
