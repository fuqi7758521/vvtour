package com.usual.entity;

public class Authority extends BaseEntity {
	
	private static final long serialVersionUID = -3144308554349101265L;
	
	private final static String collectionName = "authority";

	public Authority() {
		super(collectionName);
	}

	private String auth_id;
	
	private String auth_name;
	
	private String auth_cnname;
	
	private String auth_url;
	
	public String getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public String getAuth_url() {
		return auth_url;
	}

	public void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}

	public String getAuth_cnname() {
		return auth_cnname;
	}

	public void setAuth_cnname(String auth_cnname) {
		this.auth_cnname = auth_cnname;
	}

	@Override
	public String toString() {
		return "Authority [auth_id=" + auth_id + ", auth_name=" + auth_name
				+ ", auth_cnname=" + auth_cnname + ", auth_url=" + auth_url
				+ "]";
	}

	

	
}
