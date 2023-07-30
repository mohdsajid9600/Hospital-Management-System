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

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
			DoctorEntity dEntity = dao.findoutValidDoctor(email, password);
			HttpSession session = req.getSession();

			if (dEntity != null) {
				System.out.println("[doctorServlet.DoctorLogin.java]--The " + dEntity.getFullName()
						+ " has been successfully login into the doctor login page ");
				session.setAttribute("doctorObj", dEntity);
				resp.sendRedirect("doctor/index.jsp");
			} else {
				System.out.println(
						"[doctorServlet.DoctorLogin.java]--Wrong Doctor user try to login into the doctor login page");
				session.setAttribute("errorMsg", "Opps!!  Invalid User Id and Password.");
				resp.sendRedirect("doctor_login.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.DoctorLogin.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
