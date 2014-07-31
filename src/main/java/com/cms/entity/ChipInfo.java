package com.cms.entity;

import com.usual.entity.BaseEntity;

public class ChipInfo extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2909286818364754791L;
	
	private final static String collectionName = "chip_info";

	public ChipInfo() {
		super(collectionName);
	}

	private String chip_id;
	
	private String chip_name;			//碎片中文名称
	
	private String chip_var;			//用在页面里的变量
	
	private String chip_ca_id;
	
	private String chip_con;
	
	private String chip_con_bak;

	public String getChip_id() {
		return chip_id;
	}

	public void setChip_id(String chip_id) {
		this.chip_id = chip_id;
	}
	
	public String getChip_var() {
		return chip_var;
	}

	public void setChip_var(String chip_var) {
		this.chip_var = chip_var;
	}

	public String getChip_ca_id() {
		return chip_ca_id;
	}

	public void setChip_ca_id(String chip_ca_id) {
		this.chip_ca_id = chip_ca_id;
	}

	public String getChip_name() {
		return chip_name;
	}

	public void setChip_name(String chip_name) {
		this.chip_name = chip_name;
	}


	public String getChip_con() {
		return chip_con;
	}

	public void setChip_con(String chip_con) {
		this.chip_con = chip_con;
	}
	
	public String getChip_con_bak() {
		return chip_con_bak;
	}

	public void setChip_con_bak(String chip_con_bak) {
		this.chip_con_bak = chip_con_bak;
	}

	@Override
	public String toString() {
		return "ChipInfo [chip_id=" + chip_id + ", chip_name=" + chip_name
				+ ", chip_var=" + chip_var + ", chip_ca_id=" + chip_ca_id
				+ ", chip_con=" + chip_con + ", chip_con_bak=" + chip_con_bak
				+ "]";
	}

	
}
