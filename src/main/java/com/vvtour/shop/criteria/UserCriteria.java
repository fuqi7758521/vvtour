package com.vvtour.shop.criteria;

import com.admin.entity.User;


public class UserCriteria extends User {

	private static final long serialVersionUID = 1L;

	private SearchPagerModel<User> pageModel;

	public SearchPagerModel<User> getPageModel() {
		return pageModel;
	}

	public void setPageModel(SearchPagerModel<User> pageModel) {
		this.pageModel = pageModel;
	}

}
