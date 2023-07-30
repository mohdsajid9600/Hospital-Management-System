package com.daoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.MangeEntity;

public class ManagementDao {

	private Connection conn;

	public ManagementDao(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("Get the Object of Connection to the ManagementDao.java is = " +this.conn);
	}

	public MangeEntity forManagementLogin(String em, String pswd) {

		MangeEntity Mentity = null;
		try {

			String query = "select*from management_details where email=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, em);
			pstmt.setString(2, pswd);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Mentity = new MangeEntity();
				Mentity.setId(rs.getInt(1));
				Mentity.setEmail(rs.getString(2));
				Mentity.setPassword(rs.getString(3));

			}
			System.out.println("[ManagementDao.java]-- Anyone person login into Management login page successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [ManagementDao.java] while running the method MangeEntity forManagementLogin(String em, String pswd){} "
							+ e);
		}

		return Mentity;
	}

	public boolean checkCurrentPassword(int uid, String Currentpassword) {
		boolean f = false;

		try {

			String qurey = "select*from management_details where id=? and password=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, uid);
			pstmt.setString(2, Currentpassword);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				f = true;
			}
			System.out.println(
					"[ManagementDao.java]-- Anyone person enter wrong password for try to change password of Management login successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [ManagementDao.java] while running the method boolean checkCurrentPassword(int uid, String Currentpassword){} "
							+ e);
		}

		return f;
	}

	public boolean setNewPassword(int uid, String newpassword) {
		boolean f = false;

		try {

			String qurey = "update management_details set password=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, newpassword);
			pstmt.setInt(2, uid);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				f = true;
				System.out.println(
						"[ManagementDao.java]-- Anyone person change password of Management login successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [ManagementDao.java] while running the method boolean setNewPassword(int uid, String newpassword){} "
							+ e);
		}

		return f;
	}

}
