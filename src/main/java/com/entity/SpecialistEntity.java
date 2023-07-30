package com.entity;

public class SpecialistEntity {

	private int id;
	private String specialist;

	public SpecialistEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpecialistEntity(int id, String specialist) {
		super();
		this.id = id;
		this.specialist = specialist;
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

}
