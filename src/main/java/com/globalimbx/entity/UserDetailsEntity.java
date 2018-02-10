package com.globalimbx.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.globalimbx.json.UserDetailsJson;

@Entity
@Table(name = "UserDetails")
public class UserDetailsEntity {

	public static final String USER_ID = "userId";
	public static final String USER_GUID = "userGuid";
	public static final String USER_NAME = "userName";
	public static final String NAME = "name";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String PASSWORD = "password";
	public static final String LAST_MODIFIED_TIME = "lastModifiedTime";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId")
	private int userId;
	@Column(name = "UserGuid")
	private String userGuid;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "Name")
	private String name;
	@Column(name = "MobileNumber")
	private String mobileNumber;
	@Column(name = "Password")
	private String password;
	@Column(name = "LastModifiedTime")
	private long lastModifiedTime;
	@Column(name = "Role")
	private String role;

	public UserDetailsEntity() {

	}

	public UserDetailsEntity(UserDetailsJson userDetailsJson) {
		this.userName = userDetailsJson.getEmail();
		this.userGuid = UUID.randomUUID().toString();
		copyValue(userDetailsJson);
	}

	public void copyValue(UserDetailsJson userDetailsJson) {
		this.name = userDetailsJson.getName();
		this.mobileNumber = userDetailsJson.getMobileNumber();
		this.password = userDetailsJson.getPassword();
		this.role = userDetailsJson.getRole();
		this.lastModifiedTime = System.currentTimeMillis();
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetailsEntity [userId=" + userId + ", userName=" + userName + ", name=" + name + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}

}
