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

@WebServlet("/DrChangePassword")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int uid = Integer.parseInt(req.getParameter("uid"));
			String currentPassword = req.getParameter("currentPassword");
			String newPassword = req.getParameter("newPassword");

			HttpSession session = req.getSession();
			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());

			if (dao.checkCurrentPassword(uid, currentPassword)) {
				if (dao.setNewPassword(uid, newPassword)) {
					System.out.println(
							"[doctorServlet.ChangePasswrod.java]--Doctor Login password has been changed successfully.");
					session.removeAttribute("doctorObj");
					session.setAttribute("successMsg", "Your password has been changed successfully .");
					resp.sendRedirect("doctor_login.jsp");
				} else {
					System.out.println(
							"[doctorServlet.ChangePasswrod.java]--Something went wrong on server to change the Doctor login Password please do correct.");
					session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
					resp.sendRedirect("doctor/changePassword.jsp");
				}
			} else {
				System.out.println(
						"[doctorServlet.ChangePasswrod.java]--anyone doctor fill the incorrect current password.");
				session.setAttribute("errorMsg", "Please fill the your correct Old password.");
				resp.sendRedirect("doctor/changePassword.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.ChangePasswrod.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
