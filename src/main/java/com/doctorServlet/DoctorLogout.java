package com.doctorServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/doctorLogout")
public class DoctorLogout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();
			session.removeAttribute("doctorObj");

			session.setAttribute("successMsg", "Thank You!! You have successfully logged out.");

			resp.sendRedirect("doctor_login.jsp");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.DoctorLogout.java] while running the method protected void doGet(){} "
							+ e);
		}

	}

}
