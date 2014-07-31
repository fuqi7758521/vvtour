package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

public class CategoryInfo extends BaseEntity{
	
	private static final long serialVersionUID = -2619287783652983771L;
	
	private final static String collectionName = "category_info";
	
	public final static String TYPE_DOMESTIC = "domestic";
	
	public final static String TYPE_ABROAD = "abroad";
	
	public CategoryInfo() {
		super(collectionName);
	}
	
	private String ca_id;
	
	private String ca_name;
	
	private String ca_type;			//分类类型 domestic国内  abroad出境
	
	private String parent_id;
	
	private boolean ishas;			//是否拥有产品 0 没有; 1 有
	
	private Integer pro_num;

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

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public boolean isIshas() {
		return ishas;
	}

	public void setIshas(boolean ishas) {
		this.ishas = ishas;
	}
	
	public Integer getPro_num() {
		return pro_num;
	}

	public void setPro_num(Integer pro_num) {
		this.pro_num = pro_num;
	}
	
	public String getCa_type() {
		return ca_type;
	}

	public void setCa_type(String ca_type) {
		this.ca_type = ca_type;
	}

	@Override
	public String toString() {
		return "CategoryInfo [ca_id=" + ca_id + ", ca_name=" + ca_name
				+ ", ca_type=" + ca_type + ", parent_id=" + parent_id
				+ ", ishas=" + ishas + ", pro_num=" + pro_num + "]";
	}

}
