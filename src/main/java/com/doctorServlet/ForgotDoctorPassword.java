package com.doctorServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.DoctorDao;
import com.daoServlet.UserDao;
import com.dbConnection.DBConnection;
import com.entity.DoctorEntity;
import com.entity.UserEntity;

@WebServlet("/forgotDoctorPassword")
public class ForgotDoctorPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("name");
			String dob = req.getParameter("dob");
			String email = req.getParameter("email");
			String newPassword = req.getParameter("newPassword");

			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			DoctorEntity Dentity = dao.forgotDoctorPassword(name, dob, email);

			if (Dentity != null) {
				int id = Dentity.getId();
				if (dao.setNewPassword(id, newPassword)) {
					System.out.println(
							"[doctorServlet.ForgotDoctorPassword.java]-- forgotten password change successfully by doctor forgot page.");
					session.setAttribute("successMsg", "Your forgot password has been successfully changed.");
					resp.sendRedirect("doctor_login.jsp");
				} else {
					System.out.println(
							"[doctorServlet.ForgotDoctorPassword.java]-- Something went wrong on server to change the forgot password by Doctor forgot page, please do correct");
					session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
					resp.sendRedirect("doctor/forgotDoctorPassword.jsp");
				}
			} else {
				System.out.println(
						"[doctorServlet.ForgotDoctorPassword.java]-- Wrong details are being given by the doctor to change the forgotten password.");
				session.setAttribute("errorMsg", "The Given details is incorrect, Please fill the correct details.");
				resp.sendRedirect("doctor/forgotDoctorPassword.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.ForgotDoctorPassword.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
