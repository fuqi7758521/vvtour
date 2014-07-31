package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

public class ProductType{
	

	private static final long serialVersionUID = 3183692883946271839L;

/*	private final static String collectionName = "product_type";
	
	public ProductType() {
		super(collectionName);
	}*/

	
	private String ptype_id;
	
	private String ptype_name;

	public String getPtype_id() {
		return ptype_id;
	}

	public void setPtype_id(String ptype_id) {
		this.ptype_id = ptype_id;
	}

	public String getPtype_name() {
		return ptype_name;
	}

	public void setPtype_name(String ptype_name) {
		this.ptype_name = ptype_name;
	}

	@Override
	public String toString() {
		return "ProductType [ptype_id=" + ptype_id + ", ptype_name="
				+ ptype_name + "]";
	}
	
	

}
