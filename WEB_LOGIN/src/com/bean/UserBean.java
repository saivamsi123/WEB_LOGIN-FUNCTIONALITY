package com.bean;

public class UserBean {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String phoneNo;
	private String address;

	public UserBean() {
		super();
	}
	public UserBean(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public UserBean(int id, String username, String email, String phoneNo, String address, String password) {
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean(String username, String email) {
		this.username = username;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
}
