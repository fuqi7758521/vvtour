package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

/**
 * 二级目的地标签 
 * */
public class VisitTag extends BaseEntity {

	private static final long serialVersionUID = -670102200100358053L;
	
	private final static String collectionName = "visit_tag";
	
	public VisitTag() {
		super(collectionName);
	}

	private String visit_id;
	
	private String visit_name;
	
	public String getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}

	public String getVisit_name() {
		return visit_name;
	}

	public void setVisit_name(String visit_name) {
		this.visit_name = visit_name;
	}

	@Override
	public String toString() {
		return "VisitTag [visit_id=" + visit_id + ", visit_name=" + visit_name + "]";
	}
	
}
