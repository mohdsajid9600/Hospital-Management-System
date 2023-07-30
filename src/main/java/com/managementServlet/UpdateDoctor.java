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

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("doctorname");
			String dob = req.getParameter("doctordob");
			String qualification = req.getParameter("doctorquali");
			String specialist = req.getParameter("spec");
			String email = req.getParameter("doctoremail");
			String mobNo = req.getParameter("doctormbno");
			String password = req.getParameter("doctorpassword");

			DoctorEntity Dentity = new DoctorEntity(id, name, dob, qualification, specialist, email, mobNo, password);

			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
			boolean f = dao.updateDoctorsDetails(Dentity);
			HttpSession session = req.getSession();

			if (f) {
				System.out.println(
						"[managementServlet.UpdateDoctor.java]--  Update the Doctor details into the doctor_details database successfully by Management login");
				session.setAttribute("successMsg", "Thank You!!  The doctor details have been updated successfully.");
				resp.sendRedirect("management/doctorPage.jsp");

			} else {
				System.out.println(
						"[managementServlet.UpdateDoctor.java]-- Something went wrong on server to update doctor details by management page, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try again after sometime.");
				resp.sendRedirect("management/doctorPage.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.UpdateDoctor.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
