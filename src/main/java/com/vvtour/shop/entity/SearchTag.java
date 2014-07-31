package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

public class SearchTag extends BaseEntity {

	private static final long serialVersionUID = -5148661403810206457L;
	
	private final static String collectionName = "search_tag";
	
	protected SearchTag() {
		super(collectionName);
	}

	private String search_id;
	
	private String[] search_tags;		//标签数组
	
	private String[] tourpath;			//线路玩法
			
	private String[] from_go;			//出发城市
	
	private String[] route_days;		//行程天数

	private String[] start_date;		//出游时间
	
	private String[] traffic_form;		//交通类型
	
	private String[] views_spot;		//交通类型
	
	
}
