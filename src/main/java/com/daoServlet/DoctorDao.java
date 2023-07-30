package com.daoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.DoctorEntity;

public class DoctorDao {

	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("Get the Object of Connection to the DoctorDao.java is = " + this.conn);
	}

	public boolean addDoctors(DoctorEntity Dentity) {
		boolean f = false;

		try {
			String query = "insert into doctor_details(name,dob,qualification,specialist,email,mobNo,password) value(?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Dentity.getFullName());
			pstmt.setString(2, Dentity.getDob());
			pstmt.setString(3, Dentity.getQualification());
			pstmt.setString(4, Dentity.getSpecialist());
			pstmt.setString(5, Dentity.getEmail());
			pstmt.setString(6, Dentity.getMobileNo());
			pstmt.setString(7, Dentity.getPassword());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;
				System.out.println(
						"[DoctorDao.java] --New record added of Doctor details in doctor_details database successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean addDoctors(DoctorEntity Dentity){} "
							+ e);
		}

		return f;
	}

	public DoctorEntity forgotDoctorPassword(String name, String dob, String em) {
		DoctorEntity Dentity = null;
		try {
			String qurey = "select*from doctor_details where name=? and dob=? and email=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, name);
			pstmt.setString(2, dob);
			pstmt.setString(3, em);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Dentity = new DoctorEntity();
				Dentity.setId(rs.getInt(1));
				Dentity.setFullName(rs.getString(2));
				Dentity.setDob(rs.getString(3));
				Dentity.setQualification(rs.getString(4));
				Dentity.setSpecialist(rs.getString(5));
				Dentity.setEmail(rs.getString(6));
				Dentity.setMobileNo(rs.getString(7));
				Dentity.setPassword(rs.getString(8));
			}

			System.out.println("[DoctorDao.java]-- forgot passwrd by the Doctor Page ");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method DoctorEntity forgotDoctorPassword(String name, String dob, String em){} "
							+ e);
		}

		return Dentity;
	}

	public List<DoctorEntity> getDoctorsDetails() {
		List<DoctorEntity> list = new ArrayList<DoctorEntity>();

		try {
			DoctorEntity doctor = null;

			String query = "select * from doctor_details";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				doctor = new DoctorEntity();

				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobileNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));

				list.add(doctor);

			}
			System.out.println(
					"[DoctorDao.java]-- Get the all Doctor details from the doctor_details database successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method List<DoctorEntity> getDoctorsDetails(){} "
							+ e);
		}

		return list;
	}

	public boolean updateDoctorsDetails(DoctorEntity Dentity) {
		boolean f = false;

		try {

			String query = "update doctor_details set name=?,dob=?,qualification=?,specialist=?,email=?,mobNo=?,password=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Dentity.getFullName());
			pstmt.setString(2, Dentity.getDob());
			pstmt.setString(3, Dentity.getQualification());
			pstmt.setString(4, Dentity.getSpecialist());
			pstmt.setString(5, Dentity.getEmail());
			pstmt.setString(6, Dentity.getMobileNo());
			pstmt.setString(7, Dentity.getPassword());
			pstmt.setInt(8, Dentity.getId());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;
				System.out.println(
						"[DoctorDao.java]-- Update the Doctor details into the doctor_details database successfully by Management login");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean updateDoctorsDetails(DoctorEntity Dentity){} "
							+ e);
		}

		return f;
	}

	public boolean updateDoctorByEditProfile(DoctorEntity Dentity) {
		boolean f = false;

		try {

			String query = "update doctor_details set name=?,dob=?,qualification=?,specialist=?,email=?,mobNo=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, Dentity.getFullName());
			pstmt.setString(2, Dentity.getDob());
			pstmt.setString(3, Dentity.getQualification());
			pstmt.setString(4, Dentity.getSpecialist());
			pstmt.setString(5, Dentity.getEmail());
			pstmt.setString(6, Dentity.getMobileNo());
			pstmt.setInt(7, Dentity.getId());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;
				System.out.println(
						"[DoctorDao.java]-- Update the Doctor details into the doctor_details database successfully by doctor login");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean updateDoctorByEditProfile(DoctorEntity Dentity){} "
							+ e);
		}

		return f;
	}

	public DoctorEntity getDoctorDetailsById(int id) {

		DoctorEntity Dentity = null;

		try {

			String query = "select*from doctor_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Dentity = new DoctorEntity();

				Dentity.setId(rs.getInt(1));
				Dentity.setFullName(rs.getString(2));
				Dentity.setDob(rs.getString(3));
				Dentity.setQualification(rs.getString(4));
				Dentity.setSpecialist(rs.getString(5));
				Dentity.setEmail(rs.getString(6));
				Dentity.setMobileNo(rs.getString(7));
				Dentity.setPassword(rs.getString(8));
			}

			System.out.println(
					"[DoctorDao.java]-- Get the particular Doctor details by its Id from the doctor_details database successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method DoctorEntity getDoctorDetailsById(int id){} "
							+ e);
		}

		return Dentity;
	}

	public boolean deleteDoctorDetails(int id) {
		boolean f = false;
		try {
			String q = "delete from doctor_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(q);

			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			System.out.println(count);

			if (count == 1) {
				f = true;
				System.out.println(
						"[DoctorDao.java]-- Delete the particular Doctor details into the doctor_details database successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean deleteDoctorDetails(int id){} "
							+ e);
		}

		return f;
	}

	public DoctorEntity findoutValidDoctor(String em, String pswd) {

		DoctorEntity Dentity = null;
		try {

			String query = "select*from doctor_details where email=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, em);
			pstmt.setString(2, pswd);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Dentity = new DoctorEntity();
				Dentity.setId(rs.getInt(1));
				Dentity.setFullName(rs.getString(2));
				Dentity.setDob(rs.getString(3));
				Dentity.setQualification(rs.getString(4));
				Dentity.setSpecialist(rs.getString(5));
				Dentity.setEmail(rs.getString(6));
				Dentity.setMobileNo(rs.getString(7));
				Dentity.setPassword(rs.getString(8));

			}
			System.out.println("[DoctorDao.java]-- anyone login into the doctor login page successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method DoctorEntity findoutValidDoctor(String em, String pswd){} "
							+ e);
		}

		return Dentity;
	}

	public boolean checkCurrentPassword(int uid, String Currentpassword) {
		boolean f = false;

		try {

			String qurey = "select*from doctor_details where id=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, uid);
			pstmt.setString(2, Currentpassword);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean checkCurrentPassword(int uid, String Currentpassword){} "
							+ e);
		}

		return f;
	}

	public boolean setNewPassword(int uid, String newpassword) {
		boolean f = false;

		try {

			String qurey = "update doctor_details set password=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, newpassword);
			pstmt.setInt(2, uid);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;

				System.out.println("[DoctorDao.java]-- NewPassword SET of the Doctor login successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method boolean setNewPassword(int uid, String newpassword){} "
							+ e);
		}

		return f;
	}

	public int countDoctors() {
		int count = 0;

		try {

			String query = "select*from doctor_details";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				count++;
			}

			System.out.println("[DoctorDao.java]-- Total count check of Doctor form the doctor_details database");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [DoctorDao.java] while running the method int countDoctors(){} "
							+ e);
		}

		return count;
	}
}