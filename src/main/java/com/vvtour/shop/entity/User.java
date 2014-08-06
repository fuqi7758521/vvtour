package com.vvtour.shop.entity;

import java.util.Date;

import com.usual.entity.BaseEntity;

/**
 * 用户实体类
 * 
 * @author fuqi
 * @date 2014-08-04
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private final static String collectionName = "user";

	public User() {
		super(collectionName);
	}

	private String userId;

	private String username;

	private String nickname;

	private String realname;

	private String mobile;

	private Integer validateMobilePhone;

	private String email;

	private Integer validateEmail;

	private String password;

	private Integer status;

	private Date lastLoginDate;

	private Date birthday;

	private Integer sex;

	private String province;

	private String city;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getValidateMobilePhone() {
		return validateMobilePhone;
	}

	public void setValidateMobilePhone(Integer validateMobilePhone) {
		this.validateMobilePhone = validateMobilePhone;
	}

	public Integer getValidateEmail() {
		return validateEmail;
	}

	public void setValidateEmail(Integer validateEmail) {
		this.validateEmail = validateEmail;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
