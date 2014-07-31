package com.usual.entity;

public class ManageMenu extends BaseEntity {

	private static final long serialVersionUID = -8148036997698376757L;

	private final static String collectionName = "manage_menu";
	
	public ManageMenu() {
		super(collectionName);
	}
	
	private String menu_id;
	
	private String menu_name;
	
	private String menu_cnname;
	
	private Authority auth;
	
	private String comments;

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public Authority getAuth() {
		return auth;
	}

	public void setAuth(Authority auth) {
		this.auth = auth;
	}

	public String getMenu_cnname() {
		return menu_cnname;
	}

	public void setMenu_cnname(String menu_cnname) {
		this.menu_cnname = menu_cnname;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ManageMenu [menu_id=" + menu_id + ", menu_name=" + menu_name
				+ ", menu_cnname=" + menu_cnname + ", auth=" + auth
				+ ", comments=" + comments + "]";
	}

	
	
	
	

}
