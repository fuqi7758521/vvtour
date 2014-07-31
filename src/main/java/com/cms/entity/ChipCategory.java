package com.cms.entity;

import com.usual.entity.BaseEntity;

public class ChipCategory extends BaseEntity {
	
	private static final long serialVersionUID = -6420112785293832984L;
	
	private final static String collectionName = "chip_category";

	public ChipCategory() {
		super(collectionName);
	}

	private String chip_ca_id;
	
	private String chip_ca_name;
	
	private String page_url;

	public String getChip_ca_id() {
		return chip_ca_id;
	}

	public void setChip_ca_id(String chip_ca_id) {
		this.chip_ca_id = chip_ca_id;
	}

	public String getChip_ca_name() {
		return chip_ca_name;
	}

	public void setChip_ca_name(String chip_ca_name) {
		this.chip_ca_name = chip_ca_name;
	}

	public String getPage_url() {
		return page_url;
	}

	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
	
	
}
