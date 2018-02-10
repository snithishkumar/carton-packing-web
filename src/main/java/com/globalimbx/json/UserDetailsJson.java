package com.globalimbx.json;

import com.globalimbx.entity.UserDetailsEntity;

public class UserDetailsJson {
	
	private String userGuid;
	private String name;
	private String email;
	private String mobileNumber;
	private String password;
	private String role;
	
	public UserDetailsJson(){
		
	}
	
	public UserDetailsJson(UserDetailsEntity userDetailsEntity){
		this.userGuid = userDetailsEntity.getUserGuid();
		this.name = userDetailsEntity.getName();
		this.email = userDetailsEntity.getUserName();
		this.mobileNumber = userDetailsEntity.getMobileNumber();
		this.password = userDetailsEntity.getPassword();
		this.role = userDetailsEntity.getRole();
	}
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserGuid() {
		return userGuid;
	}
	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDetailsJson [userGuid=" + userGuid + ", name=" + name + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	

}
