package com.daoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.SpecialistEntity;

public class SpecialistDao {

	private Connection conn;

	public SpecialistDao(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("Get the Object of Connection to the SpecialistDao.java is = " +this.conn);
	}

	public boolean addSpecialist(String spec) {
		boolean f = false;

		try {

			String sql = "insert into specialist_table(specName) value(?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, spec);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				f = true;
				System.out.println(
						"[SpecialistDao.java]-- New record added of Specialist details in specialist_table database successfully..");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [SpecialistDao.java] while running the method boolean addSpecialist(String spec){} "
							+ e);
		}

		return f;
	}

	public List<SpecialistEntity> getSpecialist() {
		List<SpecialistEntity> list = new ArrayList<SpecialistEntity>();

		try {
			SpecialistEntity spec = null;

			String query = "select * from specialist_table";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				spec = new SpecialistEntity();

				spec.setId(rs.getInt(1));
				spec.setSpecialist(rs.getString(2));
				list.add(spec);

			}
			System.out.println(
					"[SpecialistDao.java]-- Get all Specialist details from specialist_table database successfully..");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [SpecialistDao.java] while running the method List<SpecialistEntity> getSpecialist(){} "
							+ e);
		}

		return list;
	}

	public int countSpecialist() {
		int count = 0;

		try {

			String query = "select*from specialist_table";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				count++;
			}
			System.out.println(
					"[SpecialistDao.java]-- Total count Specialist details from specialist_table database check by management login");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [SpecialistDao.java] while running the method int countSpecialist(){} "
							+ e);
		}

		return count;
	}

}
