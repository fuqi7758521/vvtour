package com.vvtour.shop.entity;

import java.util.List;

import com.usual.entity.BaseEntity;

public class ViewSpotTag extends BaseEntity {


	private static final long serialVersionUID = 8731016914954710628L;
	
	private final static String collectionName = "views_tag";
	
	public ViewSpotTag() {
		super(collectionName);
	}


	private String views_id;
	
	private String views_name;
	
	private List<VisitTag> visitList;

	public String getViews_id() {
		return views_id;
	}

	public void setViews_id(String views_id) {
		this.views_id = views_id;
	}

	public String getViews_name() {
		return views_name;
	}

	public void setViews_name(String views_name) {
		this.views_name = views_name;
	}

	public List<VisitTag> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<VisitTag> visitList) {
		this.visitList = visitList;
	}

	@Override
	public String toString() {
		return "ViewSpotTag [views_id=" + views_id + ", views_name="
				+ views_name + ", visitList=" + visitList + "]";
	}
	
	
	
	
}
