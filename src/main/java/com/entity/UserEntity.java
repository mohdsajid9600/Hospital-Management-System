package com.entity;

public class UserEntity {

	private int id;
	private String fullname;
	private String dob;
	private String address;
	private String email;
	private String password;
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", address=" + address + ", email="
				+ email + ", password=" + password + "]";
	}


	public UserEntity(int id, String fullname, String dob, String address, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
	}


	public UserEntity(String fullname, String dob, String address, String email, String password) {
		super();
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}


	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
