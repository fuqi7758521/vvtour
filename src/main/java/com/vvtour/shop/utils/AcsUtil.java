package com.vvtour.shop.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vvtour.shop.entity.User;
import com.vvtour.shop.service.UserService;

public class AcsUtil {
	
	public static User getLoginUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return user;
	}
	//把登录用放入session
	public static void addLoginUserToSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
	
	//把登录用放入session
	public static void reAddLoginUserToSession(HttpServletRequest request, String userId, UserService userService){
		User user = userService.getUser(userId);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
	
	public static void removeLoginUserFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
