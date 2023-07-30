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

@WebServlet("/updateDoctorInAppoint")
public class UpdateDoctInApoint extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));
			int doctorId = Integer.parseInt(req.getParameter("doctorId"));

			AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			if (dao.updateDoctorIdApoint(id, doctorId)) {
				System.out.println(
						"[managementServlet.UpadteDoctInAppoint.java]-- appointment forward to another Doctor so that update doctor id into the appointment database by login of management");
				session.setAttribute("successMsg",
						"Alert!! The appointment has been successfully forwarded to another doctor.");
				resp.sendRedirect("management/patientAppointment.jsp");
				
			} else {
				System.out.println(
						"[managementServlet.UpadteDoctInAppoint.java]-- Something went wrong on server doen't forwarded another Doctor, please do correct. ");
				session.setAttribute("errorMsg", "Something went wrong on server please try again after sometime.");
				resp.sendRedirect("management/handleAnotherDoctor.jsp");

			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.UpadteDoctInAppoint.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
