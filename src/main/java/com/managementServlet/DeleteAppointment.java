package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.AppointmentDao;
import com.dbConnection.DBConnection;

@WebServlet("/DeleteAppointment")
public class DeleteAppointment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));

			AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			if (dao.deleteAppointmentDetails(id)) {
				System.out.println(
						"[managementServlet.DeleteAppointment.java]-- Appointments completed by the management login have been deleted successfully.");
				session.setAttribute("successMsg", "The completed appointment has been successfully deleted by you.");
				resp.sendRedirect("management/patientAppointment.jsp");
			} else {
				System.out.println(
						"[managementServlet.DeleteAppointment.java]-- Something went wrong on server to delete complete appointment please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try again after sometime.");
				resp.sendRedirect("management/patientAppointment.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.DeleteAppointment.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
