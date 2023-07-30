package com.daoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.entity.AppointEntity;


public class AppointmentDao {

	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("Get the Object of Connection to the AppointmentDao.java is = " +this.conn);
	}

	public boolean insertAppointDetails(AppointEntity apoint) {
		boolean f = false;

		try {

			String query = "insert into appointment_details(user_id,fullname,gender,age,appointment_date,email,phone_no,diseases,doctor_id,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, apoint.getUserId());
			pstmt.setString(2, apoint.getFullName());
			pstmt.setString(3, apoint.getGender());
			pstmt.setString(4, apoint.getAge());
			pstmt.setString(5, apoint.getAppointDate());
			pstmt.setString(6, apoint.getEmail());
			pstmt.setString(7, apoint.getPhoneNo());
			pstmt.setString(8, apoint.getDiseases());
			pstmt.setInt(9, apoint.getDoctorId());
			pstmt.setString(10, apoint.getAddress());
			pstmt.setString(11, apoint.getStatus());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;
				System.out.println("[AppointmentDao.java] --New record added of appointment details in appointment_details database successfully..");
			}

		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method boolean insertAppointDetails(AppointEntity apoint){} " + e);
		}

		return f;
	}
	
	public List<AppointEntity> getAllPatientsAppointment() {

		List<AppointEntity> list = new ArrayList<AppointEntity>();
		AppointEntity Aentity = null;

		try {

			String query = "select*from appointment_details";

			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				Aentity = new AppointEntity();

				Aentity.setId(rs.getInt(1));
				Aentity.setUserId(rs.getInt(2));
				Aentity.setFullName(rs.getString(3));
				Aentity.setGender(rs.getString(4));
				Aentity.setAge(rs.getString(5));
				Aentity.setAppointDate(rs.getString(6));
				Aentity.setEmail(rs.getString(7));
				Aentity.setPhoneNo(rs.getString(8));
				Aentity.setDiseases(rs.getString(9));
				Aentity.setDoctorId(rs.getInt(10));
				Aentity.setAddress(rs.getString(11));
				Aentity.setStatus(rs.getString(12));

				list.add(Aentity);
			}
			
			System.out.println("[AppointmentDao.java] fetch all appointment details from appointment database  ");

		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method List<AppointEntity> getAllPatientsAppointment() {} " + e);
		}

		return list;
	}

	public List<AppointEntity> getUserAppointDetailsByUserId(int userId) {

		List<AppointEntity> list = new ArrayList<AppointEntity>();
		AppointEntity Aentity = null;

		try {

			String query = "select*from appointment_details where user_id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Aentity = new AppointEntity();

				Aentity.setId(rs.getInt(1));
				Aentity.setUserId(rs.getInt(2));
				Aentity.setFullName(rs.getString(3));
				Aentity.setGender(rs.getString(4));
				Aentity.setAge(rs.getString(5));
				Aentity.setAppointDate(rs.getString(6));
				Aentity.setEmail(rs.getString(7));
				Aentity.setPhoneNo(rs.getString(8));
				Aentity.setDiseases(rs.getString(9));
				Aentity.setDoctorId(rs.getInt(10));
				Aentity.setAddress(rs.getString(11));
				Aentity.setStatus(rs.getString(12));

				list.add(Aentity);
				
			}
			
			
			System.out.println("[AppointmentDao.java] fetch appointment details from appointment database by user login ");

		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method List<AppointEntity> getUserAppointDetailsByUserId(int userId){} " + e);
		}

		return list;
	}

	public List<AppointEntity> getUserAppointDetailsByDoctorId(int doctorId) {

		List<AppointEntity> list = new ArrayList<AppointEntity>();
		AppointEntity Aentity = null;

		try {

			String query = "select*from appointment_details where doctor_id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, doctorId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Aentity = new AppointEntity();

				Aentity.setId(rs.getInt(1));
				Aentity.setUserId(rs.getInt(2));
				Aentity.setFullName(rs.getString(3));
				Aentity.setGender(rs.getString(4));
				Aentity.setAge(rs.getString(5));
				Aentity.setAppointDate(rs.getString(6));
				Aentity.setEmail(rs.getString(7));
				Aentity.setPhoneNo(rs.getString(8));
				Aentity.setDiseases(rs.getString(9));
				Aentity.setDoctorId(rs.getInt(10));
				Aentity.setAddress(rs.getString(11));
				Aentity.setStatus(rs.getString(12));

				list.add(Aentity);
				
			}
			System.out.println("[AppointmentDao.java] fetch appointment details from appointment database by Doctor login ");
			
		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method List<AppointEntity> getUserAppointDetailsByDoctorId(int doctorId){} " + e);
		}

		return list;
	}

	public AppointEntity getAppointDetailsById(int id) {

		AppointEntity Aentity = null;

		try {

			String query = "select*from appointment_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Aentity = new AppointEntity();

				Aentity.setId(rs.getInt(1));
				Aentity.setUserId(rs.getInt(2));
				Aentity.setFullName(rs.getString(3));
				Aentity.setGender(rs.getString(4));
				Aentity.setAge(rs.getString(5));
				Aentity.setAppointDate(rs.getString(6));
				Aentity.setEmail(rs.getString(7));
				Aentity.setPhoneNo(rs.getString(8));
				Aentity.setDiseases(rs.getString(9));
				Aentity.setDoctorId(rs.getInt(10));
				Aentity.setAddress(rs.getString(11));
				Aentity.setStatus(rs.getString(12));

			}

			System.out.println("[AppointmentDao.java] fetch appointment details from appointment database by perticular appintment id");
			
		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method AppointEntity getAppointDetailsById(int id){} " + e);
		}

		return Aentity;
	}

	public boolean updateStatus(int apointid, int doctorId, String status) {

		boolean f = false;

		try {

			String query = "update appointment_details set status=? where id=? and doctor_id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, status);
			pstmt.setInt(2, apointid);
			pstmt.setInt(3, doctorId);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				f = true;
				System.out.println("[AppointmentDao.java] Update status into the appointment database by login of Doctor ");
			}

		} catch (Exception e) {
			System.out.println(
					"An error has been found in the [AppointmentDao.java] while running the method boolean updateStatus(int apointid, int doctorId, String status)){} " + e);
		}

		return f;
	}
	
	public boolean updateDoctorIdApoint(int apointId, int doctorId) {

		boolean f = false;

		try {

			String query = "update appointment_details set doctor_id=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, doctorId);
			pstmt.setInt(2, apointId);
			

			int count = pstmt.executeUpdate();

			if (count > 0) {
				f = true;
				System.out.println("[AppointmentDao.java]- appointment forward to another Doctor so that update doctor id into the appointment database by login of management");
			}

		} catch (Exception e) {
			System.out.println(
					"An error has been found in the [AppointmentDao.java] while running the method boolean updateDoctorIdApoint(int apointId, int doctorId){} " + e);
		}

		return f;
	}
	public boolean deleteAppointmentDetails(int id) {
		boolean f = false;
		try {
			String q = "delete from appointment_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(q);

			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			System.out.println(count);

			if (count == 1) {
				f = true;
				System.out.println("[AppointmentDao.java] Delete particular appointment details into the appointment database by login of management or user ");
			}

		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method boolean deleteAppointmentDetails(int id){} " + e);
		}

		return f;
	}
	
	public int countAppointments() {
		int count=0;
		
		try {
			
			String query="select*from appointment_details";
			Statement stmt=conn.createStatement();
		    ResultSet rs=stmt.executeQuery(query);
			
		    while(rs.next()) {
		    	count++;
		    }
		    System.out.println("[AppointmentDao.java] total count of details of appointment from the appointment database");
		    
		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method int countAppointments(){} " + e);
		}
		
		return count;
	}
	
	public int countAppointmentsByDoctorId(int doctorId) {
		int count=0;
		
		try {
			
			String query="select*from appointment_details where doctor_id=?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, doctorId);
			
		    ResultSet rs=pstmt.executeQuery();
			
		    while(rs.next()) {
		    	count++;
		    }
		    
		    System.out.println("[AppointmentDao.java] total count of details of appointment from the appointment database checked by doctor login");
		    
		} catch (Exception e) {
			System.out.println("An error has been found in the [AppointmentDao.java] while running the method int countAppointmentsByDoctorId(int doctorId){} " + e);
		}
		
		return count;
	}
}
