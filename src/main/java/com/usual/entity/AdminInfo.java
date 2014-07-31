package com.usual.entity;

import java.util.Arrays;

public class AdminInfo extends BaseEntity {

	private static final long serialVersionUID = 2510045547095396879L;

	private final static String collectionName = "admin_info";
	
	public AdminInfo() {
		super(collectionName);
	}
	
    /**
     * 用户解锁对应的状态值
     */
    public static final int USER_UNAUDITED = 0;
    
    /**
     * 用户解锁对应的状态值
     */
    public static final int USER_OPEN = 1;
	
	/**
     *锁定用户对应的状态值 
     */
    public static final int USER_LOCK = -1;
    
    
    /**
     * 普通管理员
     */
    public static final int RANK_ADMIN = 0;
    /**
     * 超级管理员
     */
    public static final int RANK_SUPER_ADMIN = 1;
    
	
	private String admin_id;
	
	private String admin_name;
	
	private String real_name;
	
	private String password;
	
	private long regist_time;
	
	private String[] auths;
	
	private String email;
	
	private long last_login;
	
	private String last_ip;
	
	private int rank;
	
	private int status;
	
	private String department;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(long regist_time) {
		this.regist_time = regist_time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getLast_login() {
		return last_login;
	}

	public void setLast_login(long last_login) {
		this.last_login = last_login;
	}

	public String getLast_ip() {
		return last_ip;
	}

	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String[] getAuths() {
		return auths;
	}

	public void setAuths(String[] auths) {
		this.auths = auths;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "AdminInfo [admin_id=" + admin_id + ", admin_name=" + admin_name
				+ ", real_name=" + real_name + ", password=" + password
				+ ", regist_time=" + regist_time + ", auths="
				+ Arrays.toString(auths) + ", email=" + email + ", last_login="
				+ last_login + ", last_ip=" + last_ip + ", rank=" + rank
				+ ", status=" + status + ", department=" + department + "]";
	}

}
