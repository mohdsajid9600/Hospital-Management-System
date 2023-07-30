package com.entity;

public class DoctorEntity {
	
	private int id;
	private String fullName;
	private String dob;
	private String qualification;
	private String specialist;
	private String email;
	private String mobileNo;
	private String password;
	
	public DoctorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public DoctorEntity(int id, String fullName, String dob, String qualification, String specialist, String email,
			String mobileNo, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}



	public DoctorEntity(String fullName, String dob, String qualification, String specialist, String email,
			String mobileNo, String password) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.email = email;
		this.mobileNo = mobileNo;
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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the specialist
	 */
	public String getSpecialist() {
		return specialist;
	}

	/**
	 * @param specialist the specialist to set
	 */
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", qualification=" + qualification
				+ ", specialist=" + specialist + ", email=" + email + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}
	
	

}
