package com.usual.entity;

public class AlbumPic extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6906132827810522460L;
	
	private final static String collectionName = "album_pic";
	
	public AlbumPic() {
		super(collectionName);
	}

	private String pic_id;
	
	private String pic_name;
	
	private String pic_url;
	
	private String pic_comment;
	
	private String album_id;

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getPic_comment() {
		return pic_comment;
	}

	public void setPic_comment(String pic_comment) {
		this.pic_comment = pic_comment;
	}

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getPic_id() {
		return pic_id;
	}

	public void setPic_id(String pic_id) {
		this.pic_id = pic_id;
	}

	@Override
	public String toString() {
		return "AlbumPic [pic_id=" + pic_id + ", pic_name=" + pic_name
				+ ", pic_url=" + pic_url + ", pic_comment=" + pic_comment
				+ ", album_id=" + album_id + "]";
	}

	
	
}
