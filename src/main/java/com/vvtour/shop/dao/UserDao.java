package com.vvtour.shop.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.entity.User;

/**
 * 用户DAO
 * 
 * @author fuqi
 * @date 2014-08-02 15:37
 */
public interface UserDao {

	/**
	 * 获取单个用户信息
	 * 
	 * @param query
	 * @return
	 */
	User queryUser(Query query);

	/**
	 * 编辑用户信息（包括编辑用户信息、屏蔽用户、删除用户）
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	boolean editUser(Query query, Update update);

	/**
	 * 添加用户
	 * 
	 * @param to
	 * @return
	 */
	void add(User to);

	/**
	 * 获取用户列表
	 * 
	 * @param query
	 * @return 用户列表
	 */
	List<User> queryUserList(Query query);

	/**
	 * 获取用户列表数
	 * 
	 * @param query
	 * @return 用户列表数
	 */
	Long queryUserCount(Query query);

}
