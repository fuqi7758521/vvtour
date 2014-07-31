package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

public class TourPath extends BaseEntity {

	private static final long serialVersionUID = -7767045198366650391L;
	
	private final static String collectionName = "tour_path";
	
	public TourPath() {
		super(collectionName);
	}

	private String path_id;
	
	private String path_name;
	
	private String ca_id;			//分类ID
	
	private String ca_name;			//分类名称

	public String getPath_id() {
		return path_id;
	}

	public void setPath_id(String path_id) {
		this.path_id = path_id;
	}

	public String getPath_name() {
		return path_name;
	}

	public void setPath_name(String path_name) {
		this.path_name = path_name;
	}

	public String getCa_id() {
		return ca_id;
	}

	public void setCa_id(String ca_id) {
		this.ca_id = ca_id;
	}

	public String getCa_name() {
		return ca_name;
	}

	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
	}

	@Override
	public String toString() {
		return "TourPath [path_id=" + path_id + ", path_name=" + path_name
				+ ", ca_id=" + ca_id + ", ca_name=" + ca_name + "]";
	}
	
	
}
