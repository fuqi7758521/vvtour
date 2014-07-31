package com.vvtour.shop.entity;

import java.util.List;

import com.usual.entity.BaseEntity;

/**
 * 一级标签   
 * */
public class VisitParent extends BaseEntity {

	private static final long serialVersionUID = 4903103659152912141L;
	
	private final static String collectionName = "visit_parent";
	
	public VisitParent() {
		super(collectionName);
	}
	
	private String vparent_id;
	
	private String vparent_name;
	
	private String vparent_type="abroad";				//一级标签类型 ：abroad属于出境游 domestic属于国内游
	
	private List<VisitTag> visit_tag;
	

	public String getVparent_id() {
		return vparent_id;
	}

	public void setVparent_id(String vparent_id) {
		this.vparent_id = vparent_id;
	}

	public String getVparent_name() {
		return vparent_name;
	}

	public void setVparent_name(String vparent_name) {
		this.vparent_name = vparent_name;
	}

	public List<VisitTag> getVisit_tag() {
		return visit_tag;
	}

	public void setVisit_tag(List<VisitTag> visit_tag) {
		this.visit_tag = visit_tag;
	}

	public String getVparent_type() {
		return vparent_type;
	}

	public void setVparent_type(String vparent_type) {
		this.vparent_type = vparent_type;
	}

	@Override
	public String toString() {
		return "VisitParent [vparent_id=" + vparent_id + ", vparent_name="
				+ vparent_name + ", vparent_type=" + vparent_type
				+ ", visit_tag=" + visit_tag + "]";
	}


}
