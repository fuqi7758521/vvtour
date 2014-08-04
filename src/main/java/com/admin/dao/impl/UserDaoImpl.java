package com.admin.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.admin.dao.UserDao;
import com.admin.entity.User;
import com.usual.dao.BaseDao;

/**
 * 用户DAO实现
 * @author fuqi
 * @date 2014-08-02 15:50
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User queryUser(Query query) {
		return (User)queryOne(query,new User());
	}

	@Override
	public boolean editUser(Query query, Update update) {
		User user = (User) findAndModify(query, update, new User());
		if(user!=null){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUserList(Query query) {
		return (List<User>) queryList(query, new User());
	}

	@Override
	public Long queryUserCount(Query query) {
		return getCount(query, new User());
	}

	

}
