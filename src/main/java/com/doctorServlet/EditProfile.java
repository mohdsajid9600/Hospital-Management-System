package com.doctorServlet;

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

@WebServlet("/editProfile")
public class EditProfile extends HttpServlet {

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

			DoctorEntity Dentity = new DoctorEntity(id, name, dob, qualification, specialist, email, mobNo, "");

			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());

			HttpSession session = req.getSession();

			if (dao.updateDoctorByEditProfile(Dentity)) {
				DoctorEntity updated = dao.getDoctorDetailsById(id);
				System.out.println(
						"[doctorServlet.EditProfile.java]--Update the Doctor information into the doctor_details database successfully by doctor EditPage.");
				session.setAttribute("doctorObj", updated);
				session.setAttribute("successMsg", "Thank You!!  Your Details Updated Successfully");
				resp.sendRedirect("doctor/index.jsp");

			} else {
				System.out.println(
						"[doctorServlet.EditProfile.java]--Something went wrong on server to update the Doctor information by Doctor EditPage, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("doctor/editProfile.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.EditProfile.java] while running the method protected void doPost(){} "
							+ e);
		}

	}
}
