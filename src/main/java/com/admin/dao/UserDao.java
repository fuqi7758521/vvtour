package com.admin.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.admin.entity.User;


/**
 * 用户DAO
 * @author fuqi
 * @date 2014-08-02 15:37
 */
public interface UserDao {

	/**
	 * 获取单个用户信息
	 * @param query
	 * @return
	 */
	public User queryUser(Query query);
	
	/**
	 * 编辑用户信息（包括编辑用户信息、屏蔽用户、删除用户）
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean editUser(Query query, Update update);
	
	/**
	 * 获取用户列表
	 * @param query
	 * @return 用户列表
	 */
	public List<User> queryUserList(Query query);
	
	/**
	 * 获取用户列表数
	 * @param query
	 * @return 用户列表数
	 */
	public Long queryUserCount(Query query);
	
}
