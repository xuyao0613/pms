package com.pms.entity;



public class UserInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1392594443251969435L;
	
	
	private String userName;
	private String userPassword;
	private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
}
