package com.daoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.entity.UserEntity;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("Get the Object of Connection to the UserDao.java is = " + this.conn);
	}

	public boolean userRegister(UserEntity user) {
		boolean f = false;
		try {
			String query = "insert into user_details(fullname,dob,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, user.getFullname());
			pstmt.setString(2, user.getDob());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());

			int count = pstmt.executeUpdate();
			System.out.println(count);
			if (count > 0) {
				f = true;
				System.out.println(
						"[UserDao.java]-- New User register and insert data into user_details database successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method boolean userRegister(UserEntity user){} "
							+ e);
		}
		return f;
	}

	public UserEntity forgotUserPassword(String name, String dob, String em) {
		UserEntity Uentity = null;
		try {
			String qurey = "select*from user_details where fullname=? and dob=? and email=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, name);
			pstmt.setString(2, dob);
			pstmt.setString(3, em);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Uentity = new UserEntity();
				Uentity.setId(rs.getInt(1));
				Uentity.setFullname(rs.getString(2));
				Uentity.setDob(rs.getString(3));
				Uentity.setAddress(rs.getString(4));
				Uentity.setEmail(rs.getString(5));
				Uentity.setPassword(rs.getString(6));
			}
			System.out.println(
					"[UserDao.java]-- AnyOne Person try to forgot passwword for user login has been successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method UserEntity forgotUserPassword(String name, String dob, String em){} "
							+ e);
		}

		return Uentity;
	}

	public UserEntity getUserDetails(String em, String ps) {
		UserEntity u = null;
		try {
			String query = "select*from user_details where email=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, em);
			pstmt.setString(2, ps);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				u = new UserEntity();
				u.setId(rs.getInt(1));
				u.setFullname(rs.getString(2));
				u.setDob(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setPassword(rs.getString(5));
			}

			System.out.println("[UserDao.java]-- AnyOne Person login into user login has been successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method UserEntity getUserDetails(String em, String ps){} "
							+ e);
		}

		return u;
	}

	public boolean checkCurrentPassword(int uid, String Currentpassword) {
		boolean f = false;

		try {

			String qurey = "select*from user_details where id=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, uid);
			pstmt.setString(2, Currentpassword);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method boolean checkCurrentPassword(int uid, String Currentpassword){} "
							+ e);
		}

		return f;
	}

	public boolean setNewPassword(int uid, String newpassword) {
		boolean f = false;

		try {

			String qurey = "update user_details set password=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, newpassword);
			pstmt.setInt(2, uid);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;

				System.out.println(
						"[UserDao.java]-- AnyOne Person change the Newpasswword for user login has been successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method boolean setNewPassword(int uid, String newpassword){} "
							+ e);
		}

		return f;
	}

	public boolean updateUserByEditProfile(UserEntity Uentity) {
		boolean f = false;

		try {

			String query = "update user_details set fullname=?,dob=?,address=?,email=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, Uentity.getFullname());
			pstmt.setString(2, Uentity.getDob());
			pstmt.setString(3, Uentity.getAddress());
			pstmt.setString(4, Uentity.getEmail());
			pstmt.setInt(5, Uentity.getId());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;

				System.out.println(
						"[UserDao.java]-- Upadted user Details into user_details database successfully by particular user EditPage.");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method boolean updateUserByEditProfile(UserEntity Uentity){} "
							+ e);
		}

		return f;
	}

	public UserEntity getUserDetailsById(int id) {

		UserEntity Uentity = null;

		try {

			String query = "select*from user_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Uentity = new UserEntity();

				Uentity.setId(rs.getInt(1));
				Uentity.setFullname(rs.getString(2));
				Uentity.setDob(rs.getString(3));
				Uentity.setAddress(rs.getString(4));
				Uentity.setEmail(rs.getString(5));
				Uentity.setPassword(rs.getString(6));
			}

			System.out.println(
					"[UserDao.java]-- Get User Details By its Id from user_details database successfully by Management/User Login page.");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method UserEntity getUserDetailsById(int id){} "
							+ e);
		}

		return Uentity;
	}

	public List<UserEntity> getAllUsersDetails() {

		List<UserEntity> list = new ArrayList<UserEntity>();
		UserEntity Uentity = null;

		try {

			String query = "select*from user_details";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				Uentity = new UserEntity();

				Uentity.setId(rs.getInt(1));
				Uentity.setFullname(rs.getString(2));
				Uentity.setDob(rs.getString(3));
				Uentity.setAddress(rs.getString(4));
				Uentity.setEmail(rs.getString(5));
				Uentity.setPassword(rs.getString(6));
				list.add(Uentity);
			}

			System.out.println(
					"[UserDao.java]-- Get All User Details from user_details database successfully by Management Login page.");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method List<UserEntity> getAllUsersDetails(){} "
							+ e);
		}

		return list;
	}

	public int countUsers() {
		int count = 0;

		try {

			String query = "select*from user_details";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				count++;
			}

			System.out.println(
					"[UserDao.java]-- Total count User inserted into user_details database checked by Management Login page.");
		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method int countUsers(){} "
							+ e);
		}

		return count;
	}

	public boolean DeleteUserById(int userId) {
		boolean f = false;

		try {

			String query = "delete from user_details where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;

				System.out.println(
						"[UserDao.java]-- Delete particular User Details By its Id from user_details database successfully by Management Login page.");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [UserDao.java] while running the method boolean DeleteUserById(int userId){} "
							+ e);
		}

		return f;
	}
}
