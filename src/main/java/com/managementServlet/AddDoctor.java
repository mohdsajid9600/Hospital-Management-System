package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.DoctorDao;
import com.dbConnection.DBConnection;
import com.entity.DoctorEntity;



@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("doctorname");
			String dob = req.getParameter("doctordob");
			String qualification = req.getParameter("doctorquali");
			String specialist = req.getParameter("spec");
			String email = req.getParameter("doctoremail");
			String mobileNo = req.getParameter("doctormbno");
			String password = req.getParameter("doctorpassword");

			DoctorEntity Dentity = new DoctorEntity(name, dob, qualification, specialist, email, mobileNo, password);
			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
			boolean f = dao.addDoctors(Dentity);
			HttpSession session = req.getSession();

			if (f) {
				System.out.println(
						"[managementServlet.AddDoctor.java]-- New record added of Doctor details in doctor_details database successfully bt management login page.");
				session.setAttribute("successMsg", "Thank You!! New Doctor Details Added Successfully.");
				resp.sendRedirect("management/doctorPage.jsp");
			} else {
				System.out.println(
						"[managementServlet.AddDoctor.java]-- Something went wrong on server to add new Doctor, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("management/doctorPage.jsp");

			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.AddDoctor.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
